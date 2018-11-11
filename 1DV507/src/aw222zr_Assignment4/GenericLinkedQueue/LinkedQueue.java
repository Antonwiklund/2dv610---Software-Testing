package aw222zr_Assignment4.GenericLinkedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * A class which implements the interface 'Queue'.<br>
 * This class implements methods which can be used in the following ways:<br>
 * size(): Check for queue size.<br>
 * isEmpty(): Check whether queue is empty.<br>
 * enqueue(): Add element to queue, through adding it to a node.<br>
 * dequeue(): Return and remove element from queue.<br>
 * first(): Return which is the first element in the queue.<br>
 * last(): Return which is the last element in the queue.<br>
 * toString(): Print queue toString.<br>
 * iterator(): Iterator for the queue.<br>
 * 
 * Additional methods, not derived from the interface 'Queue':<br>
 * iteratorNode(): Solely used in order for the iterator to be instantiated correctly.
 * 
 * @author Anton Wiklund
 * @since  2018-01-31
 *
 */

public class LinkedQueue<T> implements Queue<T> {

	private int queueSize;
	public Node<?> head;
	public Node<?> tail;
	public Node<?> current;
	
	/**
	 * Constructor. Instantiates LinkedQueue.
	 */
	public LinkedQueue() {
		head = null;
		tail = null;
		queueSize = 0;
	}
	
	/**
	 * Method for returning the current size of the queue.
	 * @return size of queue.
	 */
	public int size() {
		return queueSize;
	}
		
	/**
	 * Method for returning the head variable to instantiate iterator.
	 * @return head of the queue.
	 */
	@SuppressWarnings("unchecked")
	public Node<T> iteratorNode() {		
		return (Node<T>) head;
	}
	
	/**
	 * Method for checking whether the queue is empty or not.
	 * @return true if empty.
	 * @return false if not empty.
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Method for adding an object to the queue.
	 * @param element to be added to the queue.
	 */
	public void enqueue(T element) {
		if (isEmpty()) {
			Node<T> newNode = new Node<T>(element);
			queueSize++;
			head = newNode;
			tail = newNode;
		} else {	
			Node<T> newNode = new Node<T>(element);
			tail.nextLink = (Node<T>) newNode;
			tail = newNode;
			queueSize++;
		}
	}

	/**
	 * Method for returning an object from the queue, and removing it.
	 * 
	 */
	public T dequeue() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException("No element in queue to remove.");
		}
		
		// remove current 'head', move head.nextLink to 'head'.

		@SuppressWarnings("unchecked")
		T objectToRemove = (T) head.data; 
		@SuppressWarnings("unchecked")
		Node<T> nextInQue = (Node<T>) head.nextLink;
		head.nextLink = null;
		head = nextInQue;
		queueSize--;
		
		return objectToRemove;
	}

	/**
	 * Method for checking which the first(head) object in the queue is.
	 * @return The element in head node.
	 */
	@SuppressWarnings("unchecked")
	public T first() {
		if (head == null) {
			return null;
		}
		
		return (T) head.data;
	}

	/**
	 * Method for checking which the last(tail) object in the queue is.
	 * @return The element in tail node.
	 */
	@SuppressWarnings("unchecked")
	public T last() {
		if (tail == null) {
			return null;
		}
		
		return (T) tail.data;
	}
	
	/**
	 * Method for returning a string which displays all the objects in the queue.
	 * @return String made up of objects.
	 */
	public String toString() {
		String queueString = "[";
		
		Iterator<T> it = iterator();
		
		int i = 1;
		int j = 0;
		
		T instance = null;
		
		while (it.hasNext()) {
			instance = it.next();
			queueString += "Value in position " + i + " of queue: " +  instance + ". Value is instanceof: " + instance.getClass() + " | ";
			i++;
			j++;
			if (j == 4) {
				queueString += "\n ";
				j = 0;
			}
		}
				
		queueString += "]";
		return queueString;
	}

	/**
	 * Method for instantiating an iterator for the queue.
	 * @return iterator for queue.
	 */
	public Iterator<T> iterator() {
		
		return new QueueIterator<T>();
	}
	

	@SuppressWarnings("hiding")
	private class QueueIterator<T> implements Iterator<T> {

		private int sizeCounter = 1;
		@SuppressWarnings("unchecked")
		private Node<T> firstNode = (Node<T>) iteratorNode();
		private Node<T> current = null;
		// securityCheck makes sure that NoSuchElementException for 'current' is only thrown if current == null
		// after a first element has already been added.
		private boolean securityCheck = false;
		
		/**
		 * Method to check whether there exists a next node.
		 * @return true if there exists a next node.
		 * @return false if there does not exist a next node. 
		 */
		public boolean hasNext() {
			if (size() >= sizeCounter) {
				return true;
			}
			return false;
		}

		/**
		 * Method to return the current node's object.
		 * @return firstData if first node object.
		 * @return currentData if not first node object. 
		 */
		@SuppressWarnings("unchecked")
		public T next() throws NoSuchElementException  {
			if (firstNode == null) {
				throw new NoSuchElementException("No nodes have been added to the queue.");
			}
			
			if (current == null && securityCheck == true) { 
				throw new NoSuchElementException("No next element.");
			}
			
			if (current == null) {
				T firstData = (T) firstNode.data;
				current = (Node<T>) firstNode.nextLink;
				sizeCounter++;
				securityCheck = true;
				return firstData;
			}
			T currentData = current.data;
			current = (Node<T>) current.nextLink;
			sizeCounter++;
			return currentData;
		}
	}
}

