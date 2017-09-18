package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;


/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - cow.
 * Does not move. 
 * If the player occupies the same tile as a cow, the cow will be replaced with a tipped cow.
 * Tipping all the cows on the secret cow level wins the game.
 * Typically (but not necessarily) indicated with 'C' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class Cow extends GamePiece {

	public Cow(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == super.getLocation()) {
			return InteractionResult.TIP;
		}
		return InteractionResult.NONE;
	}
}
