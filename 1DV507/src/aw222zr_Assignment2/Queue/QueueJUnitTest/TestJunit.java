package aw222zr_Assignment2.Queue.QueueJUnitTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw222zr_Assignment2.Queue.CircularArrayQueue;
import aw222zr_Assignment2.Queue.LinkedQueue;

public class TestJunit {
	// SetUp: enter an integer to decide number of nodes for LinkedQueue. To test CircularArrayQueue with values of your choice,
	// manually modify test-methods below.
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
	// Test for CircularArray: that at first size is '0', and after an enqueue size is '1'.
	@Test
	public void testSize() {
		LinkedQueue testLinkedSize = new LinkedQueue();
		assertEquals(0, testLinkedSize.size());
		testLinkedSize.enqueue(2);
		testLinkedSize.enqueue(2);
		assertEquals(2, testLinkedSize.size());
		
		CircularArrayQueue testSize = new CircularArrayQueue(6);
		assertEquals(0, testSize.size());
		testSize.enqueue(1);
		assertEquals(1, testSize.size());
	}
	
	// Test: that the node used for iterator-initialization == null when no object, and != null when object has been enqueued,.
	@Test 
	public void testIteratorNode() {
		LinkedQueue testLinkedNode = new LinkedQueue();
		assertEquals(null,testLinkedNode.iteratorNode());
		testLinkedNode.enqueue(1);
		assertNotNull(testLinkedNode.iteratorNode());		
	}
	
	// Test for LinkedQueue: that queue is empty, then add object and test that is not empty.
	// Test for Cir: first that queue is empty, and then enqueue one object and test that queue is not empty.
	@Test
	public void testIsEmpty() {
		LinkedQueue testLinkedEmpty = new LinkedQueue();
		assertTrue(testLinkedEmpty.isEmpty());
		testLinkedEmpty.enqueue(1);
		assertFalse(testLinkedEmpty.isEmpty());
		
		CircularArrayQueue testEmpty = new CircularArrayQueue(6);
		assertEquals(true, testEmpty.isEmpty());
		testEmpty.enqueue(1);
		assertEquals(false, testEmpty.isEmpty());
	}
	
	// Test for LinkedQueue: that the current head-node has no attached object, then add node and look for attached object.
	// Test for CircularArray: that it has no head. Then add object and check if queue has a head.
	@Test
	public void testFirst() {
		LinkedQueue testLinkedFirst = new LinkedQueue();
		assertEquals(null,testLinkedFirst.first());
		testLinkedFirst.enqueue(1);
		assertNotNull(testLinkedFirst.first());
		
		CircularArrayQueue testFirst = new CircularArrayQueue(6);
		assertEquals(null, testFirst.first());
		testFirst.enqueue(4);
		assertEquals(4, testFirst.first());
	}
	
	// Test for LinkedQueue: that the current tail-node has no attached object, then add objects and look for attached object.
	// Test for CircularArray: that it has no tail. Then add object and check if has tail.
	@Test
	public void testLast() {
		LinkedQueue testLinkedTail = new LinkedQueue();
		assertEquals(null,testLinkedTail.last());
		testLinkedTail.enqueue(1);
		testLinkedTail.enqueue(12);
		assertEquals(12,testLinkedTail.last());
		
		CircularArrayQueue testTail = new CircularArrayQueue(6);
		assertEquals(null, testTail.last());
		testTail.enqueue(4);
		testTail.enqueue(4);
		testTail.enqueue(5);
		assertEquals(5, testTail.last());
	}
	
	// Test for LinkedQueue: that toString returns a string.
	// Test for : that toString returns a string.
	@Test
	public void testToString() {
		LinkedQueue testLinkedString = new LinkedQueue();
		testLinkedString.enqueue(1);
		String testString = testLinkedString.toString();
		assertEquals(testString, testLinkedString.toString());
		
		CircularArrayQueue testToString = new CircularArrayQueue(6);
		testToString.enqueue(2);
		String testCircString = testToString.toString();
		assertEquals(testCircString, testToString.toString());
	}
	
	// Test for LinkedQueue: that hasNext() returns false when no next, and true when has next.
	// Test for CircularArrayQueue: that hasNext() returns false if no next, and true if has next.
	@Test
	public void testHasNext() {
		LinkedQueue testLinkedIterator = new LinkedQueue();
		Iterator<Object> testIterator = testLinkedIterator.iterator(); 
		assertFalse(testIterator.hasNext());
		testLinkedIterator.enqueue(2);
		assertTrue(testIterator.hasNext());
		
		CircularArrayQueue testIt = new CircularArrayQueue(6);
		Iterator<Object> it = testIt.iterator();
		assertEquals(false, it.hasNext());
		testIt.enqueue(5);
		assertEquals(true, it.hasNext());
	}
	
	// Test for LinkedQueue: that testNext() returns the value it's supposed to return.
	// Test for CircularArrayQueue: that testNext() returns the value it's supposed to return.
	@Test
	public void testNext() {
		LinkedQueue testLinkedIterator = new LinkedQueue();
		// Test: that first object returned has a value of '1', since first object should == 1.
		Object testObject = 1;
		testLinkedIterator.enqueue(testObject);
		Iterator<Object> testIterator = testLinkedIterator.iterator(); 
		assertEquals(testObject, testIterator.next());
		
		// Test: that first instance of NoSuchElementException is thrown when there have been no objects added to the queue yet.
		// First instance of NoSuchElementException is only thrown if no objects have been added to queue which iterator iterates over.
		LinkedQueue testQueue = new LinkedQueue();
		Iterator<Object> testIterator1 = testQueue.iterator();
		assertThrows(NoSuchElementException.class,
				() -> testIterator1.next());
		
		// Test: that second instance of NoSuchElementException is thrown when there are no more objects in the queue.
		// Second instance of NoSuchElementException is only thrown after objects have been added to queue, and then all removed.
		// Because of this, we first have to add an object, then remove it, if we want to test second instance of NoSuchElementException.
		testQueue.enqueue(1);
		Iterator<Object> testIterator2 = testQueue.iterator();
		testIterator2.next();
		assertThrows(NoSuchElementException.class,
				() -> testIterator2.next());
		
		// Test: that next returns the value it's supposed to return.
		CircularArrayQueue testIt = new CircularArrayQueue(6);
		Iterator<Object> it = testIt.iterator();
		testIt.enqueue(5);
		assertEquals(5, it.next());
		
		//Test: that NoSuchElementException is thrown if no objects in CircularArrayQueue.
		CircularArrayQueue testEmpty = new CircularArrayQueue(6);
		Iterator<Object> it1 = testEmpty.iterator();
		assertThrows(NoSuchElementException.class,
				() -> it1.next());
	}
	
	// Test: that enqueue adds an object to the queue. Need to create new instance of LinkedQueue, to not affect other tests in unwanted ways.
	// Test: that enqueue adds an object to CircularArrayQueue.
	@Test
	public void testEnqueue() {
		LinkedQueue testEQ = new LinkedQueue();
		// enqueue choice of elements:
		int elementsToEQ = 5;
		for (int i = 0; i < elementsToEQ; i++) {
		testEQ.enqueue(2);
		}
		assertEquals(elementsToEQ, testEQ.size());	
		
		CircularArrayQueue testEnq = new CircularArrayQueue(6);
		testEnq.enqueue(2);
		assertEquals(1, testEnq.size());
	}
	
	// Test for LinkedQueue: return value of dequeue(). If null, throws NoSuchElementException. Need to create new instance of LinkedQueue, to not affect other tests in unwanted ways.
	// Test for CircularArray: that returns null if no objects in array. Then add object and check that correct value is returned.
	@Test
	public void testDequeue() {
		LinkedQueue testDQ = new LinkedQueue();
		// Add value of choice first, then this chosen value should be dequeued.
		Object addAndDQ = 0;
		testDQ.enqueue(addAndDQ);
		assertEquals(addAndDQ, testDQ.dequeue());
		assertThrows(NoSuchElementException.class,
			() -> testDQ.dequeue());
		
		CircularArrayQueue testDeq = new CircularArrayQueue(6);
		assertEquals(null, testDeq.dequeue());
		testDeq.enqueue(5);
		assertEquals(5, testDeq.dequeue());
	}
	
}
