package levelPieces;

import java.util.ArrayList;
import java.util.Arrays;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelEngine {

	private Drawable [] pieces;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStartLoc;
	
	// constructor
	public LevelEngine(){
		pieces = new Drawable[GameEngine.BOARD_SIZE];
		Arrays.fill(pieces, null);
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
	}
	
	private void makeLevelOne(){
		pieces[8] = new Clam();
		
		Porcupine pokey =  new Porcupine('^', 2);
		pieces[2] = pokey;
		
		playerStartLoc = 10;
	
	}
	
	private void makeLevelTwo(){

		playerStartLoc = 10;
	}
	
	// create a level
	public void createLevel(int numLevel){
		switch (numLevel){
			case 1: makeLevelOne();
					break;
			case 2: makeLevelTwo();
					break;
		}
	}
	
	// get all the pieces
	public Drawable[] getPieces(){
		return pieces;
	}
	
	// get all the pieces capable of moving
	public ArrayList<Moveable> getMovingPieces(){
		return movingPieces;
	}
	
	// get all the pieces capable of interaction
	public ArrayList<GamePiece> getInteractingPieces(){
		return interactingPieces;
	}
	
	// get starting player location
	public int getPlayerStartLoc(){
		return playerStartLoc;
	}
}
