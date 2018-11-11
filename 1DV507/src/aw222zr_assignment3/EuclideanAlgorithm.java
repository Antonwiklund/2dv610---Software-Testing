package aw222zr_assignment3;

import java.util.Scanner;

/**
 * Class for calculating the Euclidean Algorithm.<br>
 * Inhibits the following methods: <br>
 * Main(): Accepts input and runs the program.<br>
 * algorithm(): Receives the original input from main, processes it, returns the maximum divisor.<br>
 * multiplierFunc(): Calculates the correct value of the multiplier.<br>
 * remainderFunc(): Calculates the correct value of the remainder.<br>
 * 
 * @author Anton Wiklund
 *
 */

public class EuclideanAlgorithm {
		
	public static void main(String[] args) {
		// Double loops for user input:
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the 'a'-value: ");
		int a = in.nextInt();
		while (a <= 0) {
			System.out.println("'a'-value has to be an integer > 0. Enter new integer(or enter -1 to exit program): ");
			a = in.nextInt();
			if (a == -1) {
				System.exit(1);
			}
		}
		System.out.println("Enter the 'b'-value: ");
		int b = in.nextInt();
		while (b <= 0) {
			System.out.println("'b'-value has to be an integer > 0. Enter new integer(or enter -1 to exit program): ");
			b = in.nextInt();
			if (b == -1) {
				System.exit(1);
			}
		} in.close();
		// Setup the starting values of remainder and multiplier:
		int remainder = remainderFunc(a, b);
		int multiplier = multiplierFunc(a , b);
		// Start the main program:
		int maximumDivisor = algorithm(a, b, remainder, multiplier);
		System.out.println("Maximum divisor: " + maximumDivisor);
	}

	/**
	 * Calculates which the greatest common divisor of 'aPara' and 'bPara' is. 
	 * 
	 * @param aPara
	 * @param bPara
	 * @param remainderPara
	 * @param multiplierPara
	 * @return the greatest common divisor of 'a' and 'b'.
	 */
	public static int algorithm(int aPara, int bPara, int remainderPara, int multiplierPara) {
		if (bPara == 0) {
			return aPara;
		}
		// If b != 0, use recursive functions to establish new variables, until b == 0:
		multiplierPara = multiplierFunc(bPara, remainderPara);
		aPara = bPara;
		bPara = remainderPara;
		remainderPara = remainderFunc(aPara, (bPara*multiplierPara));

		return algorithm(aPara,bPara,remainderPara, multiplierPara);
	}
	
	/**
	 * Calculates the value which should be attributed to the 'multiplierPara' variable. This value is decided through the
	 * extraction of the maximum number of multiples from 'origSum', when using the value of 'toBeSubtracted'.
	 * 
	 * @param origSum
	 * @param toBeSubtracted
	 * @return the multiples-count of the two parameters.
	 */
	public static int multiplierFunc(int origSum, int toBeSubtracted) {
		int multiples = 0; 
		while (origSum >= toBeSubtracted) {
			origSum = origSum - toBeSubtracted;
			if (toBeSubtracted == 0) { // If-statement prevents infinite loop.
				break;
			}
			multiples ++;
		}
		return multiples;
	}
	
	/**
	 * Calculates the value which should be attributed to the 'remainderPara' variable. This value is decided when the maximum number
	 * of divisions of 'toBeSubtracted' against 'origSum' has been completed.
	 * 
	 * @param origSum
	 * @param toBeSubtracted
	 * @return the integer of ('origSum' - 'toBeSubtracted').
	 */
	public static int remainderFunc(int origSum, int toBeSubtracted) {
		int remainder = 0; 
		while (origSum >= toBeSubtracted) {
			origSum = origSum - toBeSubtracted;
			if (toBeSubtracted == 0) { // If-statement prevents infinite loop.
				break;
			}
		}
		remainder = origSum;
		return remainder;
	}
}
