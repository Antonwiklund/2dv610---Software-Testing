package game;

import java.util.ArrayList;
import java.util.Random;

public class DiceGame {

	/*
	 * Provides an 'int' value from 1-6.
	 */
	public int rollDice() {
		Random random = new Random();
		int diceValue = 1 + random.nextInt(6);
		return diceValue;
	}
	
}
