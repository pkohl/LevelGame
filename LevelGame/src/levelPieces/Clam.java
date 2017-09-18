package levelPieces;

import gameEngine.Drawable;


/**
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 * Gamepiece - clam.
 * Cannot move. 
 * Cannot interact.
 * Typically (but not necessarily) indicated with 'c' - this is set 
 * during level creation on a piece by piece basis.
 *
 */
public class Clam implements Drawable{

	private char symbol;
	
	public Clam(char symb){
		symbol = symb;
	}
	
	@Override
	public void draw() {
		System.out.print(symbol);		
	}

	
}
