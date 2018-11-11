package aw222zr_Assignment4.GenericLinkedQueue;

/**
 * Class which provides an instance of a node.
 * @author Anton Wiklund
 * @param <T>
 *
 */

public class Node<T> {

	public T data;
	public Node<?> nextLink;
	
	public Node(T data) {
		this.data = data;
		this.nextLink = null;
	}
}
