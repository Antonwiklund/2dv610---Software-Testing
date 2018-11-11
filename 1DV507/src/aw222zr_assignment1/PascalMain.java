package aw222zr_assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creates a representation of Pascal's triangle.
 * 
 * @author Anton Wiklund
 *
 */
public class PascalMain {

	public static void main(String[] args) {
		System.out.println("Choose the row of Pascal's triangle that you want to print:");
		Scanner in = new Scanner(System.in);
		int getRow = in.nextInt();
		while (getRow <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			getRow = in.nextInt();
			if (getRow == -1) {
				System.exit(1);
			}
		}
		in.close();

		int[] row = pascalRow(getRow);
		System.out.println("\nRow #" + getRow + ": ");
		pascalToString(row);
	}

	static ArrayList<int[]> pascalArray = new ArrayList<int[]>();
	static int rowSize = 1;
	static int[] rowAskedFor = null;

	/**
	 * Recursively creates arrays, which represent row's in Pascal's triangle.
	 * 
	 * @param n
	 */
	public static int[] pascalRow(int n) {
		int[] pascalArrayRow = new int[rowSize];
		int currentRowCurrent = 0;
		int currentRowNext = 0;
		int addToNextRow = 0;

		// Add '1' to first line row:
		if (pascalArray.size() == 0) {
			pascalArrayRow[0] = 1;
		}

		// Get array which represents the row to add from (only if first row has been
		// added):
		if (pascalArray.size() > 0) {
			int[] currentPascalRow = pascalArray.get(pascalArray.size() - 1);

			// Build the row to add to the triangle:
			if (pascalArray.size() > 0 && pascalArray.size() <= n) {
				int placementIndex = 0;
				for (int i = 0; i < pascalArray.size(); i++) {
					currentRowCurrent = currentPascalRow[i];
					currentRowNext = 0;

					// Only set currentRowNext > 0, if (currentRowCurrent != last index-value):
					if (i >= 0 && currentPascalRow.length > i + 1) {
						currentRowNext = currentPascalRow[i + 1];
					}
					// Add first index from previous row, to new row:
					if (i == 0) {
						pascalArrayRow[placementIndex++] = currentRowCurrent;
					}
					// Add indexes in between first and last index in previous row, to new row:
					if (placementIndex + 1 < pascalArrayRow.length && i >= 0 && pascalArrayRow.length != 2) {
						addToNextRow = currentRowNext + currentRowCurrent;
						pascalArrayRow[placementIndex++] = addToNextRow;
					}
					// Add last index from previous row, to new row:
					if (i == pascalArrayRow.length - 2) {
						pascalArrayRow[placementIndex] = currentRowCurrent;
					}
					currentRowNext = 0;
					currentRowCurrent = 0;
					addToNextRow = 0;
				}
			}
		}
		if (pascalArray.size() == n - 1) {
			rowAskedFor = pascalArrayRow;
		}
		// Add the triangleRow to 'pascalArray':
		if (pascalArray.size() < n) {
			pascalToString(pascalArrayRow);
			rowSize++;
			pascalArray.add(pascalArrayRow);
			pascalRow(n);
		}
		return rowAskedFor;
	}

	/**
	 * Prints an array, representing a row in Pascal's triangle.
	 * 
	 * @param rowArray
	 */
	public static void pascalToString(int[] rowArray) {
		String arrayString = "[";
		for (int i = 0; i < rowArray.length; i++) {
			if (i < rowArray.length - 1) {
				arrayString += rowArray[i] + ", ";
			} else {
				arrayString += rowArray[i];
			}
		}
		arrayString += "]";
		System.out.println(arrayString);
	}
}
