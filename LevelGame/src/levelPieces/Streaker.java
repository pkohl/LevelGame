package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - streaker.
 * Runs to the right at a rate of one tile per turn.  Pushes past other pieces - 
 * that is, if another piece is to its right, streaker swaps locations with that other piece.  
 * Does not interact with the player (can't push past the player either).
 * Typically (but not necessarily) indicated with 'S' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class Streaker extends GamePiece implements Moveable {

	public Streaker(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int startLoc = super.getLocation();	
		if (startLoc < gameEngine.GameEngine.BOARD_SIZE - 1){
			// check to see if the tile to the immediate right of the streaker is occupied by 
			// something other than the player
			if(pieces[startLoc + 1] != null && (startLoc + 1 != playerLocation)){
				// if so, swap locations
				pieces[startLoc] = pieces[startLoc + 1];
				if(pieces[startLoc] instanceof levelPieces.GamePiece) {
					((GamePiece) pieces[startLoc]).setLocation(startLoc); 
				}
				
				// replace streaker
				pieces[startLoc + 1] = this;
				super.setLocation(startLoc +1);
			}
			else{
				// if space to the right of streaker is empty, simply move over
				super.setLocation(startLoc + 1);
				pieces[startLoc + 1] = this; 
				pieces[startLoc] = null;
			}
		}

	}

}
