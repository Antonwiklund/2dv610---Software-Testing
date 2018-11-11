package aw222zr_Assignment4.GenericLinkedQueue;

import java.util.Iterator;

/**
 * An interface for implementing the necessary 'Queue'-methods.<br>
 * This interface enables a class to implement methods which can be used in the following ways:<br>
 * size(): Check for queue size.<br>
 * isEmpty(): Check whether queue is empty.<br>
 * enqueue(): Add element to queue.<br>
 * dequeue(): Return and remove element from queue.<br>
 * first(): Return which is the first element in the queue.<br>
 * last(): Return which is the last element in the queue.<br>
 * toString(): Print queue toString.<br>
 * iterator(): Iterator for the queue.<br>
 * @author Anton Wiklund
 * @since  2018-01-31
 *
 */

public interface Queue<T> {  
	   /**
	    * Method for returning the current size of the queue.
	    * @return size of queue.
	    */
	   public int size();
	   
	   /**
		 * Method for checking whether the queue is empty or not.
		 * @return true if empty.
		 * @return false if not empty.
		 */ 
	   public boolean isEmpty();      
	   
	    /**
		 * Method for adding an T to the queue.
		 * @param element to be added to the queue.
		 */
	   public void enqueue(T element);
	   
	    /**
		 * Method for returning an T from the queue, and removing it.
		 * @return the T that is being removed from the queue.
		 */
	   public T dequeue();             
	   
	    /**
		 * Method for checking which the first(head) T in the queue is.
		 * @return The element in head node.
		 */
	   public T first();  
	   
	    /**
		 * Method for checking which the last(tail) T in the queue is.
		 * @return The element in tail node.
		 */
	   public T last();       
	   
	    /**
		 * Method for returning a string which displays all the Ts in the queue.
		 * @return String made up of Ts.
		 */
	   public String toString();              
	   
	    /**
		 * Method for instantiating an iterator for the queue.
		 * @return iterator for queue.
		 */
	   public Iterator<T> iterator();    
}