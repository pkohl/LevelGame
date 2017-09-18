package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - tipped cow.
 * Cannot move.  Very angry.
 * Will kill the player on direct contact.
 * Typically (but not necessarily) indicated with '#' - this is set 
 * during level creation on a piece by piece basis.
 * Typically (but not necessarily) created via player interaction with a Cow.
 *
 */
public class TippedCow extends GamePiece {

	public TippedCow(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if(playerLocation == super.getLocation()) return InteractionResult.KILL;
		
		return InteractionResult.NONE;
		
	}

}
