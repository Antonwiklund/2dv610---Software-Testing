package aw222zr_Assignment4.BinHeap.PriorityQueue;

import java.util.ArrayList;

/**
 * Class representing a BinaryHeapQueue - priority version.
 * Incorporates methods for:
 * #Insertion.
 * #Returning element of highest priority.
 * #Returning current size of heap.
 * #toString.
 * #Determining if heap is empty.
 * #Method to decide percolation.
 * #Peek on highest priority.
 * #Check if queue contains task.
 * @author Anton Wiklund
 *
 */
public class BinaryHeapQueue implements PriorityQueue{

	private int currentSize = 0;
	private ArrayList<Task> heapArray = new ArrayList<Task>();
	private Task currentParent = null;
	private int currentValuePosition = 0;
	private int currentParentIndex = 0;
	Task root;
	private Task leftValue = null;
	private Task rightValue = null;
	private Task lastAdded = null;

	/**
	 * Insert Task into the priority-queue.
	 */
	@Override
	public void insert(Task t) {
		if (heapArray.size() == 0) { // Instantiate the heap.
			WorkTask instantiate = new WorkTask("Instantiating value", 0);
			heapArray.add(instantiate);
			heapArray.add(t);
			currentSize ++;
			lastAdded = t;
			return;
		}
		// Avoid duplicate values. Don't count index 0 as possible duplicate.
		for (int i = 1; i < heapArray.size(); i++) {
			if (heapArray.get(i) == t) {
				return;
			}
		}
		
		Task root = heapArray.get(1);		
		heapArray.add(t);
		currentValuePosition = heapArray.size() - 1;
		currentParent = heapArray.get(currentValuePosition / 2);
		currentParentIndex = currentValuePosition / 2;
		while (currentParent.getPriority() > t.getPriority()) { // Decide where to position the 'n'-value.
			if (currentParent.getTask() == root.getTask()) { // Stop the loop when it has reached the root-value.
				heapArray.set(currentParentIndex, t);
				heapArray.set(currentValuePosition, currentParent);
				break;
			}
			heapArray.set(currentParentIndex, t);
			heapArray.set(currentValuePosition, currentParent);
			currentValuePosition = currentParentIndex;
			currentParentIndex = currentValuePosition / 2;
			currentParent = heapArray.get(currentParentIndex);
		}
		lastAdded = t;
		currentSize++;
		
	}

	/**
	 * Returns, and removes, the Task of highest priority.
	 */
	@Override
	public Task pullHighest() {
		if(size() == 0) { 
			System.out.println("Heap is empty. Can only return 0."); 
			return null;
		}
		
		Task returnValue = heapArray.get(1);
		root = heapArray.get(heapArray.size() - 1);
		currentValuePosition = 1;
		
		// If-statements make sure that leftValue and rightValue are designated correct values. 
		// Final two statements take care of percolation when size of array is very small. Below, the reason for this: 
		// Main percolation-code cannot properly handle array when array is too small and has too many duplicate values. 
		// This code makes sure problematic values are setup correctly for the percolation. 
		// Without this code, return-values sometimes get returned over and over again, while at the same time over-riding the in-fact correct return-values.
		if (heapArray.size() > 2) {
			leftValue = heapArray.get(currentValuePosition * 2);
		}
		if (heapArray.size() > 3) {
			rightValue = heapArray.get((currentValuePosition * 2) + 1);
		}
		
		if (size() > 1) {
			if (returnValue.getPriority() > leftValue.getPriority()) {
				heapArray.set(currentValuePosition * 2, returnValue);
				returnValue = leftValue;
			}
		}
		
		if (size() > 2) {
			if (returnValue.getPriority() > rightValue.getPriority()) {
				heapArray.set(currentValuePosition * 2 + 1, returnValue);
				returnValue = rightValue;
			}
		}
		
		// Remove the returnValue from array, and trim array to make sure size is corrected.
		heapArray.remove(heapArray.size() - 1);
		heapArray.trimToSize();
		
		// Need to have three statements in order to control where to place the value raised to root.
		// Controls percolation:
		if (size() == 2 && rightValue != null) {		
			if (root.getPriority() > leftValue.getPriority() || root.getPriority() > rightValue.getPriority()) {
				percolateDown();
			} 
		} else if (size() > 3) {
			if (root.getPriority() > leftValue.getPriority() || root.getPriority() > rightValue.getPriority() && heapArray.size() > 2) {
				percolateDown();
			} 
		} else if (heapArray.size() > 1) { // Makes sure that current returnValue's root-position is always replaced, and doesn't end up being returned over and over.
			heapArray.set(1, root);
		}
		currentSize--;
		return returnValue;
	}

	/**
	 * Returns whether the queue already contains Task in parameter.
	 */
	@Override
	public boolean contains(Task check) {
		for (int i = 0; i < heapArray.size(); i++) {
			Task task = heapArray.get(i);
			if (task.getTask() == check.getTask()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return currentSize of queue.
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * Returns whether queue is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns Task of highest priority.
	 */
	@Override
	public Task peekHighest() {
		if (size() == 0) {
			return null;
		}
		return heapArray.get(1);
	}
	
	/**
	 * Provides a String-representation of the BinaryHeap.
	 */
	public String toString() {
		String returnString = "[";
		int count = 0;
		for (int i = 0; i < heapArray.size(); i++) {
			returnString += heapArray.get(i) + " | ";
			count++;
			if (count == 6) {
				returnString += "\n";
				count = 0;
			}
		}
		returnString += "]";
		return returnString;
	}

	/**
	 * Controls percolation.
	 */
	private void percolateDown() {
		while (root.getPriority() > leftValue.getPriority() || root.getPriority() > rightValue.getPriority()) {
			if (leftValue.getPriority() < rightValue.getPriority()) { // If-statement which runs if the value moved to root should percolate down to the left.
				heapArray.set(currentValuePosition, leftValue);
				currentValuePosition = currentValuePosition * 2;
				heapArray.set(currentValuePosition, root);
				// If-statement determines if while-loop should keep going, or break. Updates variables if should keep going.
				if (currentValuePosition * 2 < heapArray.size()) {
					leftValue = heapArray.get(currentValuePosition * 2);
					if (currentValuePosition * 2 + 1 < heapArray.size()) {
						rightValue = heapArray.get((currentValuePosition * 2) + 1);
					}
				} else if (currentValuePosition * 2 >= heapArray.size()) {
					break;
				}
			} else if (leftValue.getPriority() > rightValue.getPriority()) { // If-statement which runs if the value moved to root should percolate down to the right.
				heapArray.set(currentValuePosition, rightValue);
				currentValuePosition = (currentValuePosition * 2) + 1;
				if (currentValuePosition >= heapArray.size()) {
					heapArray.set(currentValuePosition/2, root);
				} else {
					heapArray.set(currentValuePosition, root);
				}
				// If-statement determines if while-loop should keep going, or break. Updates variables if should keep going.
				if (currentValuePosition * 2 < heapArray.size()) {
					leftValue = heapArray.get(currentValuePosition * 2);
					if (currentValuePosition * 2 + 1 < heapArray.size()) {
						rightValue = heapArray.get((currentValuePosition * 2) + 1);
					}
				} else if (currentValuePosition * 2 >= heapArray.size()) {
					break;
				}
			} else if (leftValue.getPriority() == rightValue.getPriority()) { // if leftValue == rightValue, the program proceeds as if leftValue < rightValue. 
				break;
			}
		}
	}
}
