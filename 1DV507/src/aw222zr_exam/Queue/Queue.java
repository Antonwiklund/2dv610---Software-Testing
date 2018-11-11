package aw222zr_exam.Queue;

public interface Queue {
	int size();
	boolean isEmpty();
	void enqueue(int element);
	int dequeue();
	boolean contains(int n);
	String toString();
}
