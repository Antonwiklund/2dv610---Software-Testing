package aw222zr_Assignment2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Main class for LinkedQueue.
 * Runs the LinkedQueue program.
 * 
 * @author Anton Wiklund
 *
 */

public class LinkedQueueMain {

	public static void main(String[] args) {	
		try {
		LinkedQueue queueTest = new LinkedQueue();
				
		Scanner in = new Scanner(System.in);
		System.out.println("Choose the number of objects you want to fill the queue with(Only integers > 0) :");
		int numberOfObjects = in.nextInt();
		while (numberOfObjects <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			numberOfObjects = in.nextInt();
			if (numberOfObjects == -1) {
				System.exit(1);
			}
		} in.close();
		
		
		for (int i = 1; i <= numberOfObjects; i++) {
			String object = "i";
			// Add element to the queue.
			queueTest.enqueue(object);
		}

		// Return size of the queue.
		queueTest.size();
		
		// Check if queue is empty.
		queueTest.isEmpty();
		
		// Return head element, and remove it.
		queueTest.dequeue();
		queueTest.dequeue();
		

		System.out.println("Empt"  + queueTest.isEmpty());
		
		// Return which is the current 'head' element.
		queueTest.first();
		
		// Return which is the current 'tail' element.
		queueTest.last();
		
		// Return a string representation of the elements currently waiting in the queue. 
		System.out.println(queueTest.toString());
		
		// Iterate over the elements in the queue.
		Iterator<Object> queueIterator = queueTest.iterator();
		
		// Return if has next element.
		queueIterator.hasNext();
		
		// Return next element.
		queueIterator.next();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}	
}
