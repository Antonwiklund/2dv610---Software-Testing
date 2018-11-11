package aw222zr_dv507_exam;

import java.util.Scanner;

/**
 * Provides various recursive methods.
 * Recursive methods supports the following functionality:
 * #Printing an int[] backwards.
 * #Returning value of division of two integers.
 * @author Anton Wiklund
 *
 */
public class Recursion {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Choose the size of array(Only integers > 0) :");
		int arraySize = in.nextInt();
		while (arraySize <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			arraySize = in.nextInt();
			if (arraySize == -1) {
				System.exit(1);
			}
		} in.close();
		
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++) {
			array[i] = i+1;
		}
		printBackwards(array, arraySize-1);
		
		
		int numberOfDivides = intDivide(0, 0);
		System.out.println(numberOfDivides);
		
	}
	
	/**
	 * Returns the number of times which value 'b' can be fully extracted from value 'a'.
	 */
	static int result = 0;
	static int checkA = 0;
	private static int intDivide(int a, int b) {
		if (a < 0 || b < 0) {
			throw new RuntimeException("Both 'a' and 'b' must be positive");
		}
		if (a >= checkA + b) {
			checkA += b; 
			result++;
			intDivide(a, b);
		}
		
		return result;
	}
	
	
	/**
	 * Prints, in a backwards fashion, the values of an int[].
	 */
	static int numbersPrinted = 0;
	private static void printBackwards(int[] arr, int n) {
		if (numbersPrinted == 0) {
			System.out.print("[");
		}
		
		if (numbersPrinted == arr.length-1) {
			System.out.println(arr[n-numbersPrinted] + "]" + "\n");
			return;
		}
		
		System.out.print(arr[n-numbersPrinted] + ", ");
		numbersPrinted++;
		printBackwards(arr, n);
		
	}

}
