package aw222zr_exam.Queue;

import java.util.NoSuchElementException;

public class QueueClass implements Queue {

	// Constructor:
	public QueueClass(int length) {
		stack = new int[length];
	}
	
	private int currentSize = 0;
	private int[] stack;
	
	/**
	 * Check the current elements in the stack.
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * Check if stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Add element to stack.
	 */
	@Override
	public void enqueue(int element) {
		if (currentSize < stack.length) {
			stack[currentSize] = element;
			currentSize++;
		} else {
			System.out.println(("Can't add more elements to stack. Would overflow. Dequeue before adding new elements."));
		}
	}

	/**
	 * Remove element from stack.
	 */
	@Override
	public int dequeue() throws NoSuchElementException {
		if (isEmpty() == true) {
			throw new NoSuchElementException("Stack is empty, couldn't dequeue.");
		}
		int returnValue = stack[0];
		
		for (int i = 0; i < currentSize-1; i++) {
			stack [i] = stack[i+1];	
		}
		currentSize--;
		return returnValue;
	}

	/**
	 * Check if the stack contains the value of interest.
	 */
	@Override
	public boolean contains(int n) {
		
		for (int i = 0; i < currentSize; i++) {
			if (stack[i] == n) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Represent the stack in the form of a string.
	 */
	public String toString() {
		
		String string = "[";
		for (int i = 0; i < currentSize; i++) {
			string += stack[i];
			if (i < currentSize-1) {
				string += ',' ;
			}
		}
		string += "]";
		return string;
	}

}
