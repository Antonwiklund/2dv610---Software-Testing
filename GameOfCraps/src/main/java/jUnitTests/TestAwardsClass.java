package jUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Award;

public class TestAwardsClass {

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
	 * should return an 'object' of Award-class.
	 */
	@Test
	public void shouldReturnAwardObject() {
		Award award = new Award();
		// Create award, and check that it is of the value expected.
		award.createAward();
		String actual = award.getValue();
		String expected = "Horse";
		
		assertEquals(actual, expected);
	}

}
