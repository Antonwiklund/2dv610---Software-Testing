package aw222zr_assignment1.intCollection;

public class CollectionMain {
	
	public static void main(String[] args) {
			
		System.out.println("Tests the StackClass, first fills array with integers:\n");
		try {
		ArrayIntStack stack = new ArrayIntStack();
		for (int i = 0; i < 8; i++) {
			stack.push(i*2);
		}
		System.out.println("Current values of stack: " + stack);
		System.out.println("Return, and remove, top value of stack: " + stack.pop());
		System.out.println("Peek on top value in stack: " + stack.peek());
		System.out.println("Size of current stack: " + stack.size());
		System.out.println("Stack is empty: " + stack.isEmpty());
		System.out.println("current index is within lower and upper boundaries: " + stack.checkIndex(6, stack.size));
		System.out.println(stack);
		
		// Makes array twice the length(increase available indexe's):
		stack.resize();
		stack.length();
		
	} catch(IndexOutOfBoundsException e) {
		e.printStackTrace();
	}
		
	
		System.out.println("\n\nTests the ArrayIntList:\n");
		
		try {
			
			ArrayIntList intList = new ArrayIntList();
			// Add three integers to the intList.
			intList.add(4);
			intList.add(5);
			intList.add(6);
			System.out.println("intList: " + intList);
			System.out.println("Number of integers stored: " + intList.size());
			System.out.println("intList is empty: " + intList.isEmpty());
			System.out.println("Check the index of value: " + intList.indexOf(8));
			
			// Add integer to index of choice(int, index):
			intList.addAt(1, 2);
			System.out.println("intList after addAt: " + intList);
			
			// Get integer at position index:
			int get = intList.get(2);
			System.out.println("Get value: " + get);
			
			// Remove integer at position index:
			intList.remove(1);
			System.out.println("List after removed index: " + intList);
		} 
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
}
