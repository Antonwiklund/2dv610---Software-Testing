package aw222zr_Assignment2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Main class for CircularArrayQueue.
 * Runs the CircularArrayQueue program.
 * 
 * @author Anton Wiklund
 *
 */

public class CircularArrayQueueMain {

	public static void main(String[] args) {
		System.out.println("Choose the length of the circular array(Only integers > 0:)");
		try {
		Scanner in = new Scanner(System.in);
		int length = in.nextInt();
		while (length <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			length = in.nextInt();
			if (length == -1) {
				System.exit(1);
			}
		} in.close();
		
		// Instantiate the array and the iterator:
		CircularArrayQueue testArray = new CircularArrayQueue(length);
		Iterator<Object> testIt = testArray.iterator();
		
		// Enqueue so circular array becomes full:
		for (int i = 0; i < length; i++) {
		testArray.enqueue(i+1);
		}		
		System.out.println("Array filled up: " + testArray);
		
		// Choose number of index's to remove:
		int remove = 2;
		for (int i = 0; i < remove; i++) {
			testArray.dequeue();
		}		
		System.out.println("Array after dequeue: " + testArray);

		// Fill up so that resize is triggered:
		int add = 3;
		for (int i = 0; i < add; i++) {
			testArray.enqueue(i+1);
		}		
		System.out.println("Array after resize: " + testArray + "\n");
		
		// Test iterator:
		System.out.println("Iterator test:");
		while (testIt.hasNext()) {
			System.out.println("Next object: " + testIt.next());
		}
		
		// Check size of array:
		System.out.println("\nSize of array: " + testArray.size());
		
		// Check if array empty:
		System.out.println("Array is empty: " + testArray.isEmpty());
		
		// Check head object:
		System.out.println("Head object: " + testArray.first());

		// Check tail object:
		System.out.println("Tail object: " + testArray.last());

		// Check toString:
		System.out.println("toString: " + testArray.toString());
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
}
