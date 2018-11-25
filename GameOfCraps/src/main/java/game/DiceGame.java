package game;

import java.util.ArrayList;
import java.util.Random;

public class DiceGame {

	@SuppressWarnings("rawtypes")
	ArrayList<ArrayList> mergedArray;
	
	/*
	 * Provides an 'int' value from 1-6.
	 */
	public int rollDice() {
		Random random = new Random();
		int diceValue = 1 + random.nextInt(6);
		return diceValue;
	}
	
	/*
	 * Imports, from table, the mergedArray.
	 */
	@SuppressWarnings("rawtypes")
	public void importMergedArray(ArrayList<ArrayList> mergedArray) {
		this.mergedArray = mergedArray;
	}
	
	/*
	 * Ends the game, and returns the mergedArray.
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> endGame() {
		return this.mergedArray;
	}
}
