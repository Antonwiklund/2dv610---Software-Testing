package aw222zr_dv507_exam.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class representing a generic stack.
 * Provides the following functionality:
 * #Returns iterator.
 * - Iterator has next() and hasNext() functionality.
 * #Returns current head.
 * #Returns current size.
 * #Returns whether stack is empty.
 * #Adds node to the stack.
 * #Peeks on head node.
 * #Pops head node.
 * #toString.
 * #Instantiate a node.
 * @author Anton Wiklund
 *
 * @param <T>
 */
public class GenericStack<T> implements Stack<T> {

	private Node tail = null;
	private Node head = null;
	private Node current = null;
	private int stackSize;

	/**
	 * Returns iterator for the stack.
	 */
	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	/**
	 * Returns the head of the stack.
	 * @return
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * Returns whether the stack is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns current size of the stack.
	 * @return
	 */
	public int size() {
		return stackSize;
	}

	/**
	 * Pushes element into the generic stack.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void push(Object element) {
		if (head == null) {
			Node addNode = new Node((T) element);
			head = addNode;
			current = head;
			stackSize++;
		} else {
			Node addNode = new Node((T) element);
			tail = addNode;
			current.nextNode = tail;
			current = tail;
			stackSize++;
		}
	}

	/**
	 * Returns current head.
	 */
	@Override
	public T peek() throws NoSuchElementException {
		if (isEmpty() == true) {
			throw new NoSuchElementException("Stack is empty.");
		}
		return head.data;
	}

	/**
	 * Returns, and removes, current head.
	 */
	@Override
	public T pop() throws NoSuchElementException {
		if (isEmpty() == true) {
			throw new NoSuchElementException("Stack is empty.");
		}
		T returnData = head.data;
		Node nextNode = head.nextNode;
		head.nextNode = null;
		head = nextNode;
		stackSize--;
		return returnData;
	}

	/**
	 * Returns a string-representation of the stack.
	 */
	@SuppressWarnings("unchecked")
	public String toString() {
		String returnString = "[";
		StackIterator iterator = new StackIterator();

		while (iterator.hasNext()) {
			Node current = (GenericStack<T>.Node) iterator.next();
			if (iterator.hasNext()) {
				returnString += current.data + " | ";
			} else {
				returnString += current.data;
			}
		}
		returnString += "]";

		return returnString;
	}

	/**
	 * Inner class representing an iterator.
	 * @author Anton Wiklund
	 *
	 */
	private class StackIterator implements Iterator<T> {

		Node current = getHead();
		int nodeCount = 0;

		/**
		 * Checks whether there is a next element in the stack.
		 */
		@Override
		public boolean hasNext() {
			if (stackSize > nodeCount && isEmpty() == false) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the next element in the stack.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public T next() {
			if (current == null) {
				throw new NoSuchElementException("Stack is empty.");
			}
			Node returnNode = current;
			current = current.nextNode;
			nodeCount++;
			return (T) returnNode;
		}

	}

	/**
	 * Private class representing a node.
	 * @author Anton Wiklund
	 *
	 */
	private class Node {

		public T data;
		public Node nextNode;

		public Node(T data) {
			this.data = data;
			this.nextNode = null;
		}
	}

}
