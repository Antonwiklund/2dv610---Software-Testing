package aw222zr_Assignment4.BinHeap.PriorityQueue;

/**
 * Main class to run BinaryHeapQueue.
 * @author Anton Wiklund
 *
 */
public class WorkMain {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		BinaryHeapQueue binaryHeap = new BinaryHeapQueue();
		
		// Collection of tasks:
		String[] taskArray = new String[13];
		taskArray[0] = "Starting the computer.";
		taskArray[1] = "Running welcome screen.";
		taskArray[2] = "Asking for password.";
		taskArray[3] = "Opening browser.";
		taskArray[4] = "Closing browser.";
		taskArray[5] = "Restarting computer.";
		taskArray[6] = "Starting.";
		taskArray[7] = "Running welcome screen again.";
		taskArray[8] = "Asking for password again.";
		taskArray[9] = "Opening browser again.";
		taskArray[10] = "Closing browser again.";
		taskArray[11] = "Closing down computer again.";
		taskArray[12] = "Starting the computer in safemode.";
		
		// Input variables:
		WorkTask task1 = new WorkTask("1", 1);
		WorkTask task2 = new WorkTask("2", 2);
		WorkTask task3 = new WorkTask("3", 3);
		WorkTask task4 = new WorkTask("4", 4);
		WorkTask task5 = new WorkTask("5", 5);
		WorkTask task6 = new WorkTask("6", 6);
		WorkTask task7 = new WorkTask("7", 7);
		WorkTask task8 = new WorkTask("8", 8);
		WorkTask task9 = new WorkTask("9", 9);
		WorkTask task10 = new WorkTask("10", 10);
		WorkTask task11 = new WorkTask("11", 11);
		WorkTask task12 = new WorkTask("12", 12);
		WorkTask task13 = new WorkTask("13", 13);
		
		// Enter commands.
		binaryHeap.insert(task1);
		binaryHeap.insert(task2);
		binaryHeap.insert(task3);
		binaryHeap.insert(task4);
		System.out.println("Queue contains task 4: " + binaryHeap.contains(task4));
		System.out.println("Queue contains task 5: " + binaryHeap.contains(task5) + "\n");
		binaryHeap.insert(task5);
		binaryHeap.insert(task6);
		binaryHeap.insert(task7);
		binaryHeap.insert(task8);
		binaryHeap.insert(task9);
		binaryHeap.insert(task10);
		binaryHeap.insert(task11);
		binaryHeap.insert(task12);
		
		// Print task queue:
		System.out.println("toString: " + binaryHeap.toString() + "\n");
		
		// Peek on highest prio. Check size. Check if empty.
		System.out.println("Peek on top prio: " + binaryHeap.peekHighest());
		System.out.println("Current size: " + binaryHeap.size());
		System.out.println("Queue is empty: " + binaryHeap.isEmpty() + "\n");
		
		// Change task for highest prio, so starts in safemode:
		Task change = binaryHeap.peekHighest();
		change.setTask("13");
		
		// Run tasks:
		System.out.println("----------------------------------------------------------------");
		for (int i = 0; i < taskArray.length; i++) {
			if(binaryHeap.size() > 0) {
			runTask(binaryHeap.pullHighest(), taskArray);
			}
		}
		System.out.println("----------------------------------------------------------------");
		// Peek on highest prio. Check size. Check if empty.
				System.out.println("\n" + "Peek on top prio: " + binaryHeap.peekHighest());
				System.out.println("Current size: " + binaryHeap.size());
				System.out.println("Queue is empty: " + binaryHeap.isEmpty());

	}
	
	/**
	 * Processes tasks.
	 * @param t
	 * @param array
	 */
	private static void runTask(Task t, String[] array) {
		String task = t.getTask();
		int taskInt = Integer.parseInt(task);
		System.out.println(array[taskInt-1] + "\n");
	}

}
