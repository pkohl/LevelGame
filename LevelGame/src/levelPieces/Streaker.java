package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

import gameEngine.Moveable;

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
		int temp = super.getLocation();		
		super.setLocation(super.getLocation() + 1);
		pieces[temp] = null;
		pieces[super.getLocation()] = this; //Streaker object replaces other game pieces
	}

}
