package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Porcupine extends GamePiece {


	
	public Porcupine(char symbol, int location) {
		super(symbol, location);

	}

	@Override
	public InteractionResult interact(Drawable[] pieces, int playerLocation) {
		if(playerLocation == super.getLocation()) return InteractionResult.KILL;
		return InteractionResult.NONE;
		
	}

}
