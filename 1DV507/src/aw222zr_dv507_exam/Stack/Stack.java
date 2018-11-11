package aw222zr_dv507_exam.Stack;

import java.util.NoSuchElementException;

public interface Stack <T> extends Iterable<T>{
	
	public boolean isEmpty();
	public void push(T x);
	public T peek() throws NoSuchElementException;
	public T pop() throws NoSuchElementException;
	public String toString();
	
}
