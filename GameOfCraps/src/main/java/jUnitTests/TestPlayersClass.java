package jUnitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPlayersClass {

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
		Players players = new Players();
		ArrayList<Players> playersList = new ArrayList<Players>(); 
		
		playersList.add(players.addPlayer());
		
		Object actual = playersList.get(0);
		Boolean expected = actual instanceof PlayerObject;
		
		assertTrue(expected);
	}

}
