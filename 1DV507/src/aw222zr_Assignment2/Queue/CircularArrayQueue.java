package aw222zr_Assignment2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A class which implements the interface 'Queue'.
 * This class implements methods which can be used in the following ways:
 * Check for queue size.
 * Check whether queue is empty.
 * Add element to queue.
 * Return and remove element from queue.
 * Return which is the first element in the queue.
 * Return which is the last element in the queue.
 * Print queue toString.
 * Iterator for the queue.
 *  
 * Additional methods, not derived from the interface 'Queue':
 * resize(). Resize the queue.
 * 
 * @author Anton Wiklund
 * @since  2018-02-08
 *
 */

public class CircularArrayQueue implements Queue {

	public CircularArrayQueue(int userInput) {
		head = null;
		tail = null;
		circularArray = new Object[userInput];
		length = userInput;
	}
	
	// Various variables:
	private int circularArraySize;
	private Object[] circularArray;
	private Object head;
	private Object tail;
	private int headPosition;
	private int tailPosition;
	private int length;
		
	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return circularArraySize;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Resizes an array to the double of its length.
	 * @param circularArrayResize
	 * @return resized array.
	 */
	private Object[] resize(Object[] circularArrayResize) {		
		Object[] resizeCircularArray = new Object[circularArrayResize.length*2];
		System.arraycopy(circularArrayResize, 0, resizeCircularArray, 0, circularArrayResize.length);
		
		return resizeCircularArray;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void enqueue(Object element) {
		Object addToQueue = element;
		
		if (circularArraySize == length) {
			
			// New array so can move values into correct index-order previous to resize().
			Object[] reorderArray = new Object[length];
			int addToIndex = 0;
			
			// First loop moves objects over from current index-position of head and forward, to new array, so head == 0 index.
			for (int i = headPosition; i < length; i++) {
				reorderArray[addToIndex] = circularArray[i];
				addToIndex++;
			}
			// Second loop moves objects which are located previous to head's index-position, so we get a chain
			// where logical position in queue also reflects the index value of this queue-position.  
			for (int i = 0; i < headPosition; i++) {
				reorderArray[addToIndex] = circularArray[i];
				addToIndex++;
			}
			// Resize array:
			circularArray = reorderArray;
			circularArray = resize(circularArray);
		
			// Update various variables:
			length = circularArray.length;
			int newLastIndex = (int) Math.floor(circularArray.length/2);
			tailPosition = newLastIndex;
			circularArray[newLastIndex] = addToQueue;
			head = circularArray[0];
			tail = circularArray[tailPosition];
			headPosition = 0;
			circularArraySize++;
			return;
		}
		
		// If object which will be added would need for the array to extend beyond current length,
		// then the position for where tail is supposed to be added is swapped to index 0.
		if (tailPosition >= length-1) {
			tailPosition = 0;
		}
	
		// First if is only necessary in order to instantiate the circular array. Only used once.
		if (head == null && circularArraySize == 0 && headPosition == 0) {
				head = addToQueue;
				circularArray[headPosition] = head;
				circularArraySize++;	
		} else if (circularArraySize < length) {
			tail = addToQueue;
			if (tailPosition == 0 && circularArray[0] == null) {
				circularArray[0] = tail;
				head = tail;
			} else {
				if (tailPosition < length-1) {	
					circularArray[++tailPosition] = tail;
				} else if (tailPosition >= length) {
					circularArray[tailPosition] = tail;
				}
			}
			circularArraySize++;
		} else if (circularArraySize <= length) {
			System.out.println("Error: Circular Array full. Dequeue existing object before enqueue'ing.");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Object dequeue() {
		
		// If the index-value of head after current dequeue would need to extend beyond current array.length,
		// then index of head is reset to 0.
		if (headPosition > length-1) {
			headPosition = 0;
		}
		
		Object removeFromQueue = head;
		if (removeFromQueue == null) {
			System.out.println("Error: No object to dequeue. Current index value null. Enqueue object before dequeue'ing.");
			return null;
		}
		
		// If statements which removes the current head and designates previous head-index = null.
		if (headPosition+1 < length) {
			head = circularArray[headPosition+1];
			circularArray[headPosition] = null;
		} else if (headPosition+1 >= length) {
			head = circularArray[0];
			circularArray[headPosition] = null;
		}
		
		headPosition++;
		circularArraySize--;
		return removeFromQueue;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object first() {
		return head;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object last() {		
		return tail;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		String arrayString = "[";
		
		Iterator<Object> it = iterator();
		while(it.hasNext()) {
			arrayString += it.next();
			if (it.hasNext()) {
				arrayString += ",";
			}
		}
		arrayString += "]";
		
		return arrayString;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Iterator<Object> iterator() {
		Iterator<Object> returnIt = new circularArrayQueueIterator();	
		return returnIt;
	}
	
	private class circularArrayQueueIterator implements Iterator<Object> {

		private int sizeCounter = 1;
		private Object firstObject;
		private Object current = null;
		private int nextPosition;
		
		/**
		 * Method to check whether there exists a next object.
		 * @return true if there exists a next object.
		 * @return false if there does not exist a next object. 
		 */
		public boolean hasNext() {
			if (size() >= sizeCounter) {
				return true;
			}
			return false;
		}

		/**
		 * Method to return the next object.
		 * @return the next object.
		 */
		public Object next() throws NoSuchElementException  {
			
			if (firstObject == null) {
				nextPosition = headPosition;
				firstObject = circularArray[nextPosition];
				if (firstObject == null) {
				throw new NoSuchElementException("No Objects have been added to the queue.");
				}
				sizeCounter++;
				nextPosition = headPosition+1;
				return firstObject;
			}
			
			if (current == null) {
				if (nextPosition >= circularArray.length) {
					nextPosition = 0;
					current = circularArray[nextPosition++];
					sizeCounter++;
					return current;
				}
				current = circularArray[nextPosition++];
				sizeCounter++;
				return current;
			}
			
			if (nextPosition >= circularArray.length) {
				nextPosition = 0;
				current = circularArray[nextPosition++];
				sizeCounter++;
				return current;
			}
			current = circularArray[nextPosition++];
			sizeCounter++;
			return current;
		}
	}

}
