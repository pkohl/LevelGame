package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;
import java.util.ArrayList;

/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - Disco Stu.
 * Dances aggressively.
 * On each turn, will randomly select between moving one square right, one square left,
 * and standing still.  Cannot move into a square occupied by another piece or the player.
 * Will inflict one point of damage to a player that is adjacent or on the same square.
 * Typically (but not necessarily) indicated with 'd' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class DiscoStu extends GamePiece implements Moveable {
	
	
	/**
	 * Possibly-allowed moves for a DiscoStu.
	 * Not strictly necessary, but gave me practice with enums.
	 *
	 */
	private enum moves{
		LEFT ("left"), RIGHT ("right"), STAY ("stay");
		private String value;
		
		moves(String aValue){
			value = aValue;
		}
		
		public String toString(){
			return value;
		}
	}
	

	public DiscoStu(char symbol, int location) {
		super(symbol, location);
	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		
		if(playerLocation == super.getLocation() || playerLocation == super.getLocation() - 1 ||
				playerLocation == super.getLocation() + 1){
			return InteractionResult.HIT;
		}
		
		return InteractionResult.NONE;
		
	}
	
	@Override
	public void move(Drawable[] pieces, int playerLocation) {
		int startLoc = super.getLocation();	
		ArrayList<moves> legalMoves = new ArrayList<moves>();
		// assemble a list of legal moves
		if (startLoc - 1 >= 0 && pieces[startLoc - 1] == null && playerLocation != (startLoc - 1) ){
			legalMoves.add(moves.LEFT);
		}
		if (startLoc + 1 < GameEngine.BOARD_SIZE - 1 && pieces[startLoc + 1] == null 
				&& playerLocation != (startLoc +1)){
			legalMoves.add(moves.RIGHT);
		}
		legalMoves.add(moves.STAY);

		// randomly choose from one of the legal moves
		Random rand = new Random();
		int numOpenings = legalMoves.size();
		moves moveTo = legalMoves.get(rand.nextInt(numOpenings));
		switch (moveTo) {
		case LEFT:
			super.setLocation(startLoc - 1);
			pieces[startLoc - 1] = this; 
			pieces[startLoc] = null;
			break;
		case RIGHT:
			super.setLocation(startLoc + 1);
			pieces[startLoc + 1] = this; 
			pieces[startLoc] = null;
			break;
		case STAY:
			break;
		}
		

	}

}
