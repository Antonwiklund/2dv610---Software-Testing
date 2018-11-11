package aw222zr_Assignment4.BinHeap.SimpleHeap;

import java.util.ArrayList;

/**
 * Class representing a BinaryHeap.
 * Incorporates methods for:
 * #Insertion.
 * #Returning element of highest priority.
 * #Returning current size of heap.
 * #toString.
 * #Determining if heap is empty.
 * #Method to decide percolation.
 * @author Anton Wiklund
 *
 */
public class BinaryIntHeap {

	private int currentSize = 0;
	private ArrayList<Integer> heapArray = new ArrayList<Integer>();
	private int currentParent = 0;
	private int currentValuePosition = 0;
	private int currentParentIndex = 0;
	int root;
	private int leftValue = 0;
	private int rightValue = 0;
	private int lastAdded = 0;

	public BinaryIntHeap() {
	}
	
	/**
	 * Inserts a value into the heap.
	 * @param designated parameter value.
	 */
	public void insert(int n) {
		if (heapArray.size() == 0) { // Instantiate the heap.
			heapArray.add(0);
			heapArray.add(n);
			currentSize ++;
			lastAdded = n;
			return;
		}
		// Avoid duplicate values. Don't count index 0 as possible duplicate.
		for (int i = 1; i < heapArray.size(); i++) {
			if (heapArray.get(i) == n) {
				return;
			}
		}
		
		int root = heapArray.get(1);		
		heapArray.add(n);
		currentValuePosition = heapArray.size() - 1;
		currentParent = heapArray.get(currentValuePosition / 2);
		currentParentIndex = currentValuePosition / 2;
		while (currentParent > n) { // Decide where to position the 'n'-value.
			if (currentParent == root) { // Stop the loop when it has reached the root-value.
				heapArray.set(currentParentIndex, n);
				heapArray.set(currentValuePosition, currentParent);
				break;
			}
			heapArray.set(currentParentIndex, n);
			heapArray.set(currentValuePosition, currentParent);
			currentValuePosition = currentParentIndex;
			currentParentIndex = currentValuePosition / 2;
			currentParent = heapArray.get(currentParentIndex);
		}
		lastAdded = n;
		currentSize++;
	}

	/**
	 * Returns the value which, based upon the value itself, has the highest priority.
	 * @return value of highest priority.
	 */
	public int pullHighest() { 
		if(size() == 0) { // QUESTION: I try to avoid using exceptions as much as possible. Is this a better solution than exception?
			System.out.println("Heap is empty. Can only return 0."); // seems unreasonable to shut down program processing over something like this.
			return 0;
		}
		
		int returnValue = heapArray.get(1);
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
		if (returnValue > leftValue) {
			heapArray.set(currentValuePosition * 2, returnValue);
			returnValue = leftValue;
		}
		if (returnValue > rightValue && heapArray.size() < 2) {
			heapArray.set(currentValuePosition * 2 + 1, returnValue);
			returnValue = rightValue;
		}
		
		// Remove the returnValue from array, and trim array to make sure size is corrected.
		heapArray.remove(heapArray.size() - 1);
		heapArray.trimToSize();
		
		// Controls percolation:
		if (root > leftValue || root > rightValue && heapArray.size() > 2) {
			percolateDown();
		} else if (heapArray.size() > 1) { // Makes sure that current returnValue's root-position is always replaced, and doesn't end up being returned over and over.
			heapArray.set(1, root);
		}
		currentSize--;
		return returnValue;
	}

	/**
	 * Returns currentSize. Doesn't count index 0 as part of the size.
	 * @return
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Returns whether BinaryHeap is empty or not.
	 * @return
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
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
			if (count == 15) {
				returnString += "\n";
				count = 0;
			}
		}
		returnString += "]";
		return returnString;
	}
	
	public int peek() {
		return heapArray.get(1);
	}
	
	public int getLastAdded() {
		return lastAdded;
	}
	
	/**
	 * Decides how the last-value which is raised to root, should percolate.
	 */
	private void percolateDown() {
		while (root > leftValue || root > rightValue) {
			if (leftValue < rightValue) { // If-statement which runs if the value moved to root should percolate down to the left.
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
			} else if (leftValue > rightValue) { // If-statement which runs if the value moved to root should percolate down to the right.
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
			} else if (leftValue == rightValue) { // if leftValue == rightValue, the program proceeds as if leftValue < rightValue. 
				break;
			}
		}
	}
 }
