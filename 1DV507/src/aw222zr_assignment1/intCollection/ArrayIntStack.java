package aw222zr_assignment1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
		
	public ArrayIntStack () {
	}
	
	public void push(int n) {
		values[size] = n;
		size++;
	}

	public int pop() throws IndexOutOfBoundsException {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("Can't remove when size of stack <= 0");
		}
		int topOfStack = values[size-1]; 
		values[size-1] = 0;
		//System.out.println(values[size]);
		size--;
		
		return topOfStack;
	}

	public int peek() throws IndexOutOfBoundsException {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("Can't peek when size of the stack == 0)");
		}
		int topOfStack = values[size-1]; 
		
		return topOfStack;
	}

	public void length() {
		int length = values.length;
		System.out.println("Possible size of stack after resize is: " + length);
	}

}
