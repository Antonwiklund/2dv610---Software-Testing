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
import org.mockito.stubbing.OngoingStubbing;

import game.Award;
import game.DiceGame;
import game.Player;
import game.Table;

public class TestGamePackage {

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
	
	/*	
	 * should only return maxsize array.
	 */
	@Test
	public void shouldNotAddPlayerToArray() {
		Player player = new playerStub();
		Table table = new Table();
		for (int i = 0; i < 12; i++) {
			table.importPlayer(player);
		}
		int actual = table.getPlayerArray().size();
		int expected = 8;
		assertEquals(actual, expected);
	}
	
	/*
	 * should return an awardsArray.
	 */
	@Test
	public void shouldReturnAwardsArray() {
		Table table = new Table();
		ArrayList<Award> actual = table.getAwardsArray();
		ArrayList<Award> expected = new ArrayList<Award>();
		assertEquals(actual, expected);
	}
	
	/*
	 * Should return an resultsArray.
	 */
	@Test
	public void shouldReturnResultsArray() {
		Table table = new Table();
		ArrayList<Integer> actual = table.getResultsArray();
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(actual, expected);
	}
	
	/*
	 * Should return an array which merges playerArray,resultsArray,awardArray.
	 */
	@Test
	public void shouldReturnMergedArrays() {
		Table table = new Table();
		ArrayList<ArrayList> mergedArray = table.mergeArrays();
		int actual = mergedArray.size();
		int expected = 3;
		assertEquals(actual, expected);
	}
	
	/*
	 * Should return an instance of the game.
	 */
	@Test
	public void shouldReturnInstanceOfTheGame() {
		Table table = new Table();
		DiceGame test = table.getGame();
		Boolean testIfTrue = test instanceof DiceGame;
		assertTrue(testIfTrue);
	}
	
	/*
	 * should assert that setup game with the mergedArray is successful.
	 */
	@Test
	public void shouldSendMergedArrayForSetupOfGame() {
		Table table = new Table();
		DiceGame mockGame = mock(DiceGame.class);
		ArrayList<ArrayList> mergedArray = table.mergeArrays();
		table.setupGame();
		when(mockGame.endGame()).thenReturn(mergedArray);
		ArrayList<ArrayList> actual = mockGame.endGame();
		assertEquals(actual, mergedArray);
	}
	
	//TESTSUITE FOR PLAYERCLASS
	
	/*
	 * Tests that it is possible to add a player to the game. 
	 */
	@Test
	public void testAddingPlayers() {
		Player player = new Player();
		ArrayList<Player> playersList = new ArrayList<Player>(); 
		
		playersList.add(player);
		
		Object actual = playersList.get(0);
		Boolean expected = actual instanceof Player;
		
		assertTrue(expected);
	}
	
	/*
	 *  Tests that it is possible to add results to the player.
	 */	
	@Test
	public void shouldAddToPlayerCurrentResult() {
		Player player = new Player();
		int expected = 5;
		player.addToResult(expected);
		player.addToResult(expected);
		int actual = player.getCurrentResult();
		
		assertEquals(10, actual);
	}
	
	@Test
	public void shouldSetAndReturnBetValue1() {
		Player player = new Player();
		player.setBetOne();
		int actual = player.getBetOne();
		int expected = 4;
		assertEquals(actual, expected);
	}
	
	@Test
	public void shouldSetAndReturnBetValue2() {
		Player player = new Player();
		player.setBetTwo();
		int actual = player.getBetTwo();
		int expected = 4;
		assertEquals(actual, expected);
	}
	
	//TESTSUITE FOR AWARDCLASS
	
	/*
	 * should return an 'object' of Award-class.
	 */
	@Test
	public void shouldReturnCorrectAwardObject() {
		Award award = new Award();
		// Create award, and check that it is of the value expected.
		String actual = award.getValue();
		String expected = "Horse";
		
		assertEquals(actual, expected);
	}
	
	
	
	//TESTSUITE FOR GAMECLASS
	
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
	
	//Dice should return a value from 1-6.
	@Test
	public void checkThatDiceFunctionsCorrectly() {
		DiceGame game = new DiceGame();
		int actual = game.rollDice();
		int expected;

		for (expected = 6; expected >= actual; expected--) {
			if (actual == expected && actual > 0 && actual < 7) {
				break;
			}
		}
		
		assertEquals(actual, expected);
	}
	
}
