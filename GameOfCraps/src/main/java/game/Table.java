package game;

import java.util.Random;

public class Table {
	
	public static void main(String[] args) {
		
	}

	/*
	 * Provides an 'int' value from 1-6.
	 */
	public int rollDice() {
		Random random = new Random();
		int diceValue = 1 + random.nextInt(6);
		return diceValue;
	}
	
}
