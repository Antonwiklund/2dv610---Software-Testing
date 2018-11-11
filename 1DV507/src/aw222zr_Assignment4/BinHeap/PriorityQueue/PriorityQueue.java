package aw222zr_Assignment4.BinHeap.PriorityQueue;

public interface PriorityQueue {

	public void insert(Task t);

	public Task pullHighest();

	public boolean contains(Task check);
	
	public int size();
	
	public boolean isEmpty();
	
	public Task peekHighest();
	
}
