package aw222zr_dv507_exam.Stack;

public class StackMain {

	public static void main(String[] args) {
		GenericStack stack = new GenericStack();
		
		// Various types, to see that GenericStack is truly functional as a generic class:
		String stringTest = "test";
		int intTest = 2;
		Object objectTest = 5;
		long longTest = 25;
		
		// Add variables:
		stack.push(intTest);
		stack.push(stringTest);
		stack.push(objectTest);
		stack.push(longTest);
		
		// Print to string:
		System.out.println("toString: " + stack.toString());
		
		// Pop 2 nodes:
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		
		// Peek on current head:
		System.out.println("Peek on head: " + stack.peek());
		
		// Add 3 new nodes to stack:
		stack.push("Bulgakov");
		stack.push(23);
		stack.push("FTW");
		
		// Print string and size:
		System.out.println("toString: " + stack.toString());
		System.out.println("Current size of stack: " + stack.size());
		
		// Pop all elements and check if isEmpty returns true:
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Stack is empty: " + stack.isEmpty());
		
		// Check so exception is thrown when isEmpty() == true:
		System.out.println("Pop: " + stack.pop());
	}
	
}
