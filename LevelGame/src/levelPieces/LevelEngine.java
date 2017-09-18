package levelPieces;

import java.util.ArrayList;
import java.util.Arrays;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;


/**
 * LevelEngine constructs gameboards corresponding to the various levels. 
 * 
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 * 
 *
 */
/**
 * @author Pat
 *
 */
public class LevelEngine {

	// This arrays serves as the gameboard - every element that isn't occupied by a game piece
	// is set to null
	private Drawable [] pieces; 
	private ArrayList<Moveable> movingPieces; // the non-player gamepieces that are allowed to move
	private ArrayList<GamePiece> interactingPieces; // the non-player gamepieces that can interact with the player
	private int playerStartLoc; // the starting location for the player piece on a particular level
	

	
	/**
	 * Constructor - creates an array of drawable pieces the size of the game board, then
	 * initializes pieces to be all null elements, and creates arrays to hold moveable and interactable pieces
	 */
	public LevelEngine(){
		pieces = new Drawable[GameEngine.BOARD_SIZE];
		Arrays.fill(pieces, null);
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
	}
	
	
	/**
	 * Helper method that clears a level before it gets repopulated
	 */
	private void clearLevel(){
		Arrays.fill(pieces, null);
		movingPieces.clear();
		interactingPieces.clear();

	}
	/**
	 * Method that populates level one with pieces
	 */
	private void makeLevelOne(){
		clearLevel();
/*		Clam chowderhead = new Clam('c');
		pieces[8] = chowderhead;
		
		Porcupine pokey =  new Porcupine('^', 2);
		pieces[2] = pokey;
		interactingPieces.add(pokey);
		
		Streaker streakey = new Streaker('S', 1);
		pieces[1] = streakey;
		movingPieces.add(streakey);*/
		
/*		BlinkGate gatey = new BlinkGate('g', 8);
		pieces[8] = gatey;
		movingPieces.add(gatey);
		interactingPieces.add(gatey);
		
		BlinkGate gatez = new BlinkGate('g', 9);
		pieces[9] = gatez;
		movingPieces.add(gatez);
		interactingPieces.add(gatez);*/
		
		playerStartLoc = 20;
		
/*		Porcupine pokey =  new Porcupine('^', 16);
		pieces[16] = pokey;
		interactingPieces.add(pokey);*/
		
/*		DiscoStu stu = new DiscoStu('d', 14);
		pieces[14] = stu;
		movingPieces.add(stu);
		interactingPieces.add(stu);*/
		
/*		Cow mooMoo = new Cow('C', 15);
		pieces[15] = mooMoo;
		interactingPieces.add(mooMoo);*/
		
		Gate gatex = new Gate('g', 9);
		pieces[9] = gatex;
		interactingPieces.add(gatex);
		

	
	}
	
	/**
	 * Method that populates level two with pieces
	 */
	private void makeLevelTwo(){
		clearLevel();

		playerStartLoc = 10;
		
		Gate gatex = new Gate('g', 9);
		pieces[9] = gatex;
		interactingPieces.add(gatex);
	}
	
	private void makeLevelThree(){
		clearLevel();

		playerStartLoc = 10;
		
		Cow mooMoo = new Cow('C', 15);
		pieces[15] = mooMoo;
		interactingPieces.add(mooMoo);
		
		Cow mewMew = new Cow('C', 12);
		pieces[12] = mewMew;
		interactingPieces.add(mewMew);
	}
	
	// create a level
	/**
	 * Helper function that creates the specified level
	 * @param numLevel number of level to create
	 */
	
	
	public void createLevel(int numLevel){
		switch (numLevel){
			case 1: makeLevelOne();
					break;
			case 2: makeLevelTwo();
					break;
			case 3: makeLevelThree();
		}
	}
	
	/**
	 * Getter for the gameboard.
	 * @return pieces, the array of drawable objects that serves as the gameboard.
	 */
	public Drawable[] getPieces(){
		return pieces;
	}
	
	/**
	 * Getter for the moveable pieces.
	 * @return movingPieces, the array of game pieces capable of movement.
	 */
	public ArrayList<Moveable> getMovingPieces(){
		return movingPieces;
	}
	
	/**
	 * Getter for the pieces capable of interacting with the player piece.
	 * @return interactingPieces, the array of pieces capable of interacting with the player piece.
	 */
	public ArrayList<GamePiece> getInteractingPieces(){		
		return interactingPieces;
	}
	
	/**
	 * Getter for the player's starting location.
	 * @return playerStartLoc, the player's starting location for this level.
	 */
	public int getPlayerStartLoc(){
		return playerStartLoc;
	}
}
