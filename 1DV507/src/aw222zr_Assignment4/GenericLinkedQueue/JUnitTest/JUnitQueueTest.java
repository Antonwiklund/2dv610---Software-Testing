package aw222zr_Assignment4.GenericLinkedQueue.JUnitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw222zr_Assignment4.GenericLinkedQueue.LinkedQueue;

class JUnitQueueTest {

		LinkedQueue<Integer> testLinked = new LinkedQueue<Integer>();
		LinkedQueue<String>  testLinked1 = new LinkedQueue<String>();
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
		
		// Test for LinkedQueue: that returned size of queue is the size '0' without objects added, and correct size after adding objects.
		@Test
		public void testSize() {
			assertEquals(0, testLinked.size());
			testLinked.enqueue(2);
			testLinked.enqueue(2);
			assertEquals(2, testLinked.size());
			
			assertEquals(0, testLinked1.size());
			testLinked1.enqueue("2");
			testLinked1.enqueue("2");
			assertEquals(2, testLinked1.size());
		}
		
		// Test: that the node used for iterator-initialization == null when no object, and != null when object has been enqueued,.
		@Test 
		public void testIteratorNode() {
			assertEquals(null,testLinked.iteratorNode());
			testLinked.enqueue(1);
			assertNotNull(testLinked.iteratorNode());	
			
			assertEquals(null,testLinked1.iteratorNode());
			testLinked1.enqueue("1");
			assertNotNull(testLinked1.iteratorNode());	
		}
		
		// Test for LinkedQueue: that queue is empty, then add object and test that is not empty.
		@Test
		public void testIsEmpty() {
			assertTrue(testLinked.isEmpty());
			testLinked.enqueue(1);
			assertFalse(testLinked.isEmpty());

			assertTrue(testLinked1.isEmpty());
			testLinked1.enqueue("1");
			assertFalse(testLinked1.isEmpty());
		}
		
		// Test for LinkedQueue: that the current head-node has no attached object, then add node and look for attached object.
		@Test
		public void testFirst() {
			assertEquals(null,testLinked.first());
			testLinked.enqueue(1);
			assertEquals(1,(int)testLinked.first());

			assertEquals(null,testLinked1.first());
			testLinked1.enqueue("1");
			assertEquals("1",(String)testLinked1.first());
		}
		
		// Test for LinkedQueue: that the current tail-node has no attached object, then add objects and look for attached object
		@Test
		public void testLast() {
			assertEquals(null,testLinked.last());
			testLinked.enqueue(1);
			testLinked.enqueue(12);
			assertEquals(12,(int)testLinked.last());

			assertEquals(null,testLinked1.last());
			testLinked1.enqueue("1");
			testLinked1.enqueue("12");
			assertEquals("12",(String)testLinked1.last());
		}
		
		// Test for LinkedQueue: that toString returns a string.
		@Test
		public void testToString() {
			testLinked.enqueue(1);
			String testString = testLinked.toString();
			assertEquals(testString, testLinked.toString());

			testLinked1.enqueue("1");
			String testString1 = testLinked1.toString();
			assertEquals(testString1, testLinked1.toString());
		}
		
		// Test for LinkedQueue: that hasNext() returns false when no next, and true when has next.
		@Test
		public void testHasNext() {
			Iterator<Integer> testIterator = testLinked.iterator(); 
			assertFalse(testIterator.hasNext());
			testLinked.enqueue(2);
			assertTrue(testIterator.hasNext());
			
			Iterator<String> testIterator1 = testLinked1.iterator(); 
			assertFalse(testIterator1.hasNext());
			testLinked1.enqueue("2");
			assertTrue(testIterator1.hasNext());
		}
		
		// Test for LinkedQueue: that testNext() returns the value it's supposed to return.
		@Test
		public void testNext() {
			// Test: that first object returned has a value of '1', since first object should == 1.
			int testObject1 = 1;
			testLinked.enqueue(testObject1);
			Iterator<Integer> testIterator1 = testLinked.iterator(); 
			assertEquals(testObject1, (int)testIterator1.next());
		
			String testObject11 = "1";
			testLinked1.enqueue(testObject11);
			Iterator<String> testIterator11 = testLinked1.iterator(); 
			assertEquals(testObject11, testIterator11.next());
			
			// Test: that first instance of NoSuchElementException is thrown when there have been no objects added to the queue yet.
			// First instance of NoSuchElementException is only thrown if no objects have yet been added to queue which iterator iterates over.
			LinkedQueue<Integer> testQueue2 = new LinkedQueue<Integer>();
			Iterator<Integer> testIterator2 = testQueue2.iterator();
			assertThrows(NoSuchElementException.class,
					() -> testIterator2.next());
			
			LinkedQueue<String> testQueue22 = new LinkedQueue<String>();
			Iterator<String> testIterator22 = testQueue22.iterator();
			assertThrows(NoSuchElementException.class,
					() -> testIterator22.next());
			
			// Test: that second instance of NoSuchElementException is thrown when there are no more objects in the queue.
			// Second instance of NoSuchElementException is only thrown after objects have been added to queue, and then all removed.
			// Because of this, we first have to add an object, then remove it, if we want to test second instance of NoSuchElementException.
			testQueue2.enqueue(1);
			Iterator<Integer> testIterator222 = testQueue2.iterator();
			testIterator222.next();
			assertThrows(NoSuchElementException.class,
					() -> testIterator222.next());
			
			testQueue22.enqueue("1");
			Iterator<String> testIterator2222 = testQueue22.iterator();
			testIterator2222.next();
			assertThrows(NoSuchElementException.class,
					() -> testIterator2222.next());
		}
		
		// Test: that enqueue adds an object to the queue.
		@Test
		public void testEnqueue() {
			// enqueue choice of elements:
			int elementsToEQ = 5;
			for (int i = 0; i < elementsToEQ; i++) {
			testLinked.enqueue(2);
			}
			assertEquals(elementsToEQ, testLinked.size());	
			
			// enqueue choice of elements:
			int elementsToEQ1 = 5;
			for (int i = 0; i < elementsToEQ1; i++) {
			testLinked1.enqueue("2");
			}
			assertEquals(elementsToEQ1, testLinked1.size());	
		}
		
		// Test for LinkedQueue: return value of dequeue(). If null, throws NoSuchElementException.
		@Test
		public void testDequeue() {
			// Add value of choice first, then this chosen value should be dequeued.
			int addAndDQ = 0;
			testLinked.enqueue(addAndDQ);
			assertEquals(addAndDQ,(int) testLinked.dequeue());
			assertThrows(NoSuchElementException.class,
				() -> testLinked.dequeue());

			// Add value of choice first, then this chosen value should be dequeued.
			String addAndDQ1 = "0";
			testLinked1.enqueue(addAndDQ1);
			assertEquals(addAndDQ1, testLinked1.dequeue());
			assertThrows(NoSuchElementException.class,
				() -> testLinked1.dequeue());
		}
}
