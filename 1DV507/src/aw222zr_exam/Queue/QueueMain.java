package aw222zr_exam.Queue;

import java.util.Scanner;

public class QueueMain {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter maximum size of stack: ");
		int sizeOfStack = in.nextInt();
		in.close();

		QueueClass stackClass = new QueueClass(sizeOfStack);

		// Fill the stack, with enqueue's:
		for (int i = 1; i <= sizeOfStack; i++) {
			stackClass.enqueue(i);
		}
		// Check stack toString:
		System.out.println("Stack after first fill: " + stackClass);
		
		// Check if try to overload stack:
		stackClass.enqueue(2);

		// Check size of stack:
		System.out.println("Current stack size: " + stackClass.size() + "\n");

		// Dequeue and return all elements:
		int elementsToDequeue = sizeOfStack;
		for (int i = 0; i < elementsToDequeue; i++) {
			System.out.println("The following element was dequeue'd: " + stackClass.dequeue());
		}
		// Check if stack is empty after dequeue:
		System.out.println("Stack is empty: " + stackClass.isEmpty());
		
		// Refill the stack, with enqueue's:
		for (int i = 1; i <= sizeOfStack; i++) {
			stackClass.enqueue(i);
		}

		// Check stack toString again:
		System.out.println("\nStack after second fill: " + stackClass);
		
		// Check if stack is empty:
		System.out.println("Stack is empty: " + stackClass.isEmpty());
		
		// Check if the element of interest exists in the stack:
		int test = 5;
		System.out.println("The element '" + test + "' is represented in the stack: " + stackClass.contains(test));

	}

}
