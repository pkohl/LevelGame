package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.ArrayList;
import java.util.Random;


/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - Blink gate.
 * Every turn, moves to a new tile on the board at random.  Since the game executes moves before it, 
 * checks for interactions, it is impossible to land on this gate intentionally.
 * Will teleport the player to the next level if the player occupies the same tile.
 * Typically (but not necessarily) indicated with 'g' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class BlinkGate extends GamePiece implements Moveable {

	public BlinkGate(char symbol, int location) {
		super(symbol, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == super.getLocation()) return InteractionResult.ADVANCE;
		return InteractionResult.NONE;
	}
	
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int temp = super.getLocation();	// starting location for the piece
		
		// find all currently-unoccupied tiles
		ArrayList<Integer> availableMoves = new ArrayList<Integer>();
		for (int i = 0; i < gameEngine.GameEngine.BOARD_SIZE; i++){
			if (pieces[i] == null) availableMoves.add(i);
		}
		
		//randomly select one of the unoccupied tiles
		Random rand = new Random();
		int numOpenings = availableMoves.size();
		int moveTo = rand.nextInt(numOpenings);
		super.setLocation(moveTo);
		pieces[moveTo] = this;
		pieces[temp] = null;
	}

}
