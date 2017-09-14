package levelPieces;

import gameEngine.Drawable;

public class Clam implements Drawable{

	private char symbol;
	
	public Clam(){
		symbol = 'c';
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);		
	}

	
}
