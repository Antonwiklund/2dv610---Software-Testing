package aw222zr_Assignment4.BinHeap.SimpleHeap.JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw222zr_Assignment4.BinHeap.SimpleHeap.BinaryIntHeap;

class JUnitHeapTest {

		BinaryIntHeap testHeap = new BinaryIntHeap();
		
		// SetUp:
		@BeforeAll
		public static void setUpOnce(){
			System.out.println("Testing intialized:\n");
		}
		
		static int testNumber;
		
		@AfterAll
		public static void cleanUp() {
			System.out.println("Number of tests finished: " + (testNumber));
		}

		@BeforeEach
		public void beforeEach() {
			testNumber++;
			System.out.println("Test number " + testNumber + " is running...");
		}
		
		@AfterEach
		public void afterEach() {
			System.out.println("Test number " + (testNumber) + " has been run.\n");
		}
		
		// Test that insert(),peek(), and getLastAdded() works:
		@Test
		public void testInsert() {
			// Positive value:
			testHeap.insert(5);
			assertEquals(5, testHeap.getLastAdded());
			// Negative value:
			testHeap.insert(-6);
			assertEquals(-6, testHeap.getLastAdded());
			// Extreme positive value:
			testHeap.insert(900011);
			assertEquals(900011, testHeap.getLastAdded());
			// Extreme negative value:
			testHeap.insert(-614214);
			assertEquals(-614214, testHeap.getLastAdded());
			// Test that returned current root is correct:
			assertEquals(-614214, testHeap.peek());
			// Test that duplicate values are ignored:
			testHeap.insert(-6);
			assertEquals(-614214, testHeap.getLastAdded());
		}
		
		// Test that correct values are pulled:
		@Test 
		public void testPullHighest() {
			testHeap.insert(-614214);
			testHeap.insert(-6);
			testHeap.insert(5);
			testHeap.insert(900011);
			// Test 1:	
			assertEquals(-614214,testHeap.pullHighest());
			// Test 2:
			assertEquals(-6,testHeap.pullHighest());
			// Test 3:	
			assertEquals(5,testHeap.pullHighest());
			// Test 4:
			assertEquals(900011,testHeap.pullHighest());
			// Test 5:
			assertEquals(0,testHeap.pullHighest());
		}
		
		// Test size returned:
		@Test
		public void testSize() {
			testHeap.insert(-614214);
			testHeap.insert(-6);
			testHeap.insert(5);
			testHeap.insert(900011);
			// Test 1:
			assertEquals(4, testHeap.size());
			testHeap.pullHighest();
			// Test 2:
			assertEquals(3, testHeap.size());
			testHeap.pullHighest();
			testHeap.pullHighest();
			testHeap.pullHighest();
			// Test 3:
			assertEquals(0, testHeap.size());
		}
		
		// Test isEmpty():
		@Test
		public void testIsEmpty() {
			// Test 1:
			assertTrue(testHeap.isEmpty());
			
			testHeap.insert(-614214);
			// Test 2:
			assertFalse(testHeap.isEmpty());
			
			testHeap.pullHighest();
			// Test 3:
			assertTrue(testHeap.isEmpty());
		}
		
		// Test that toString returns correct String:
		@Test
		public void testToString() {
			// Test 1(before heap initialized):
			assertEquals("[]", testHeap.toString());
			// Test 2(after heap initialized):
			testHeap.insert(4);
			assertEquals("[0 | 4 | ]", testHeap.toString());
			// Test 3:
			testHeap.insert(4);
			testHeap.insert(45);
			testHeap.insert(-44);
			assertEquals("[0 | -44 | 45 | 4 | ]", testHeap.toString());
			// Test 4:
			testHeap.pullHighest();
			testHeap.pullHighest();
			testHeap.pullHighest();
			testHeap.pullHighest();
			assertEquals("[0 | ]", testHeap.toString());
		}
		
		
}
