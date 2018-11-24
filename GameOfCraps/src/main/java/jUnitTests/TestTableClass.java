package jUnitTests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
		System.out.println("\nTest starts.\n");
	}
	
	@After
	public void tearDown() throws Exception {
		System.out.println("Test finished.");
	}
	
	/*
	 * Should return an 'int' specifying the total number of players.
	 */
	@Test
	public void shouldReturnNumberOfPlayers() {
		Table table = new Table();
		int numberOfPlayers = 0;
		try {
			numberOfPlayers = table.welcomeToTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int actual = numberOfPlayers; 
		int expected = 4;
		assertEquals(actual, expected);
	}
	
	/*
	 * Should return the value of a player's bets.
	 */
	@Test
	public void shouldReturnBetValue() {
		Player player1 = new playerStub();
		Player player2 = new playerStub();
		Table table = new Table();
		//add playerStubs to array:
		table.importPlayer(player1);
		table.importPlayer(player2);
		ArrayList<Player> playerArray = table.getPlayerArray();
		//send array to loop, for bets to be placed.		
		table.placeBets(playerArray);
		//Return bets to check they are correct.
		int betsValuePlayerOne = table.getBetsValue(playerArray.get(0));
		int betsValuePlayerTwo = table.getBetsValue(playerArray.get(1));
		int expected = 20;
		assertEquals(betsValuePlayerOne + betsValuePlayerTwo, expected);
	}
	
	/*
	 * Stub for Player.
	 */
	class playerStub extends Player {
		int betOne;
		int betTwo;
		
		public void setBetOne() {
			this.betOne = 5;
		}
		
		public void setBetTwo() {
			this.betTwo = 5;
		}
		
		public int getBetOne() {
			return betOne;
		}
		
		public int getBetTwo() {
			return betTwo;
		}
	}
	
	
	/*
	 * Should return an instance of 'Player' from within an ArrayList.
	 */
	@Test
	public void shouldReturnAnInstanceOfPlayer() {
		Player player = mock(Player.class);
		Table table = new Table();
		// Import mocked player-class.
		table.importPlayer(player);
		ArrayList<Player> playerArray = table.getPlayerArray();
		// Check that imported player-class has been added to array.
		Boolean actual = playerArray.get(0) instanceof Player;
		
		assertTrue(actual);
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
