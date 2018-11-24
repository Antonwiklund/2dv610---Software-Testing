package jUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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

	@Test
	public void shouldReturnAwardObject() {
		Awards awards = new Awards();
		// Create award, and check that it is of the value expected.
		Awards awardObject = awards.createAward();
		String actual = awardObject.getValue();
		String expected = "Horse";
		
		assertEquals(actual, expected);
	}

}
