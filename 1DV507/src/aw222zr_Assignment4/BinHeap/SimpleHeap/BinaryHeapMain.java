package aw222zr_Assignment4.BinHeap.SimpleHeap;

public class BinaryHeapMain {

	public static void main(String[] args) {
		BinaryIntHeap intHeap = new BinaryIntHeap();
		
		// Check isEmpty:
		System.out.println("Heap is empty: " + intHeap.isEmpty());
		
		// Insert 8 values:
		intHeap.insert(-13);
		intHeap.insert(-24);
		intHeap.insert(-6);
		intHeap.insert(-16);
		intHeap.insert(-46);
		intHeap.insert(-52);
		intHeap.insert(-7);
		intHeap.insert(-15);
		
		// Check so size works:
		System.out.println("Current size of heap: " + intHeap.size() + "\n");
		
		// Check so that pulling works correctly:
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");

		// Stress-test by adding new values:
		intHeap.insert(3);
		intHeap.insert(11);
		intHeap.insert(1);
		
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		
		// Stress-test by adding new values:
		intHeap.insert(33);
		intHeap.insert(0);
		intHeap.insert(-100);
		
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		System.out.println("Returned value of highest priority: " +intHeap.pullHighest() + "\n");
		System.out.println("Current String: " + intHeap.toString());
		
		// Check isEmpty:
		System.out.println("Heap is empty: " + intHeap.isEmpty());
		// Check so size works(should be 1):
		System.out.println("Current size of heap: " + intHeap.size() + "\n");
		
	}

}
