package aw222zr_Assignment4.GenericLinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LinkedQueueMain {

	public static void main(String[] args) {	
		try {
		LinkedQueue<String> queueTest = new LinkedQueue<String>();
				
		Scanner in = new Scanner(System.in);
		System.out.println("Choose the number of objects you want to fill the queue with(Only integers > 0) :");
		int numberOfElements = in.nextInt();
		while (numberOfElements <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			numberOfElements = in.nextInt();
			if (numberOfElements == -1) {
				System.exit(1);
			}
		} in.close();
		
		for (int i = 1; i <= numberOfElements; i++) {
			String element = ("test" + i);
			// Add element to the queue.
			queueTest.enqueue(element);
		}

		// Return size of the queue.
		queueTest.size();
		
		// Check if queue is empty.
		queueTest.isEmpty();
		
		// Return head element, and remove it.
		queueTest.dequeue();
		queueTest.dequeue();
		
		// Return which is the current 'head' element.
		queueTest.first();
		
		// Return which is the current 'tail' element.
		queueTest.last();
		
		// Return a string representation of the elements currently waiting in the queue. 
		System.out.println(queueTest.toString());
		
		// Iterate over the elements in the queue.
		@SuppressWarnings("rawtypes")
		Iterator queueIterator = queueTest.iterator();
		
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
