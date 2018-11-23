package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Player;

public class TestPlayerClass {

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

}
