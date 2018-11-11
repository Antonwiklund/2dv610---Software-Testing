package aw222zr_Assignment2.Queue;

/**
 * Class which provides an instance of a node.
 * @author Anton Wiklund
 *
 */

public class Node {

	public Object data;
	public Node nextLink;
	
	public Node(Object data) {
		this.data = data;
		this.nextLink = null;
	}
}
