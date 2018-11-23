package jUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Player;
import game.Table;

public class TestTableClass {

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Testsuite initialized:");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("\nTestsuite completed.");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("\nTest starts.");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Test finished.");
	}
	
	/*
	 * Should return an 'int'-array. The length of which, amounts to the total number of players.
	 */
	@Test
	public void shouldReturnNumberOfPlayers() {
		Table table = new Table();
		Player[] playersArray = table.welcomeToTable();
		
		int actual = playersArray.length; 
		int expected = 4;
		assertEquals(actual, expected);
	}
	
	//Dice should return a value from 1-6.
	@Test
	public void checkThatDiceFunctionsCorrectly() {
		Table table = new Table();
		int actual = table.rollDice();
		int expected;

		for (expected = 6; expected >= actual; expected--) {
			if (actual == expected && actual > 0 && actual < 7) {
				break;
			}
		}
		
		assertEquals(actual, expected);
	}
}
