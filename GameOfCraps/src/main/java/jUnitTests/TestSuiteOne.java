package jUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Table;

public class TestSuiteOne {

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
