package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - Exit gate.
 * Cannot move. 
 * Will teleport the player to the next level if the player is in direct
 * line of sight to the gate.
 * Typically (but not necessarily) indicated with 'G' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class Gate extends GamePiece {

	public Gate(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		// check for line of sight to player - look left first
		int searchLocation = super.getLocation() - 1;
		while(searchLocation >= 0){
			if(playerLocation == searchLocation) return InteractionResult.ADVANCE;
			if(pieces[searchLocation] != null) break;
			searchLocation -= 1;
		}
		
		searchLocation = super.getLocation() + 1;
		while(searchLocation < gameEngine.GameEngine.BOARD_SIZE){
			if(playerLocation == searchLocation) return InteractionResult.ADVANCE;
			if(pieces[searchLocation] != null) break;
			searchLocation += 1;
		}
		
		return InteractionResult.NONE;
		
	}

}
