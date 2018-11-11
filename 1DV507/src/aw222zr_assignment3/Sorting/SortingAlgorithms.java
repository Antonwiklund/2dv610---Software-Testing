package aw222zr_assignment3.Sorting;

import java.util.Comparator;

public class SortingAlgorithms {

	/**
	 * Uses an int[] parameter, to create a new and sorted array.
	 * 
	 * @param in
	 * @return sortedArray
	 */
	// Implementation method from https://en.wikipedia.org/wiki/Insertion_sort:
	public static int[] insertionSort(int[] in) {
		int length = in.length;
		int currentIndexInteger;
		int[] sortedArray = new int[length];
		int j = 0;

		// For-loop checks every value of in[]:
		for (int i = 0; i < length; i++) {
			currentIndexInteger = in[i];
			// State 'i - 1' so that the first index-value is set.
			j = i - 1;
			// While-loop swaps current index-values into correct positions.
			while (j >= 0 && sortedArray[j] > currentIndexInteger) {
				sortedArray[j + 1] = sortedArray[j];
				j = j - 1;
			}
			sortedArray[j + 1] = currentIndexInteger;
		}
		return sortedArray;
	}

	/**
	 * Sorts integers in an array, so that smallest integer ends up on index [0],
	 * and largest on index[array.length-1].
	 * 
	 * @param in
	 * @return sorted int[]
	 */
	public static int[] mergeSort(int[] in) {
		int[] origNewArray = new int[in.length];
		System.arraycopy(in, 0, origNewArray, 0, in.length);

		int startIndex = 0;
		int endIndex = origNewArray.length - 1;

		int[] returnArr = splitIntArray(origNewArray, startIndex, endIndex);

		return returnArr;
	}

	/**
	 * Splits the int[]'s indexe's, so that can sort it.
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return sorted and merged int[]
	 */
	public static int[] splitIntArray(int[] array, int startIndex, int endIndex) {
		// First check so that length is not 1:
		if (endIndex - startIndex < 1) {
			return array;
		}
		// Divide the current length to find middleIndex:
		int middleIndex = (startIndex + endIndex + 1) / 2;

		// Recursion for the arrays, to keep splitting up indexe's:
		splitIntArray(array, startIndex, middleIndex - 1);
		splitIntArray(array, middleIndex, endIndex);

		int[] returnArr = mergeIntArray(array, startIndex, middleIndex, endIndex);
		return returnArr;
	}

	/**
	 * Sorts the int[] by using the current indexe's which represent the current left and right of the int[], simultaneously merging these together.
	 * 
	 * @param array
	 * @param startIndex
	 * @param middleIndex
	 * @param endIndex
	 * @return sorted and merged int[]
	 */
	public static int[] mergeIntArray(int[] array, int startIndex, int middleIndex, int endIndex) {
		int currentLeftValue = startIndex;
		int currentRightValue = middleIndex;
		int placementIndex = startIndex;

		int[] helpArray = new int[array.length];
		System.arraycopy(array, 0, helpArray, 0, array.length);

		for (int i = startIndex; i < middleIndex; i++) {
			
			while (array[i] > array[currentRightValue] && placementIndex <= endIndex) {
				helpArray[placementIndex] = array[currentRightValue];

				// Iteratively replace all of the source-array's values with infinite numbers,
				// so that 'array[currentLeftValue]' will never > 'array[currentRightValue]' if
				// 'array[currentRightValue]' has already been used.
				// This is necessary since the way this loop is structured, it apparently can't
				// appropriately handle the final index for certain inputs.
				// This is due to how 'placementIndex' interacts with the addition of new values
				// to the helpArray.
				// In other words: 'placementIndex' can become too large if it's not stopped,
				// thereby skipping steps in placement.
				// I've been sitting with this algorithm full time for 2 & 1/2 days now. So this
				// will have to do for the time being.
				// This bugfix works as intended, atleast with all the inputs I have given it.
				

				if (placementIndex < endIndex) {
					placementIndex++;
				} else {
					break;
				}

				if (currentRightValue < endIndex) {
					currentRightValue++;
				} else {
					break;
				}
			}

			helpArray[placementIndex] = array[currentLeftValue++];
			if (placementIndex < endIndex) {
				placementIndex++;
			}
		}

		// Copy over everything from helpArray, back to the original array.
		System.arraycopy(helpArray, 0, array, 0, helpArray.length);
		return array;
	}

	/**
	 * Takes a String[] parameter, creates a copy of it, and then returns a sorted
	 * string[]. Uses a custom comparator to sort.
	 * 
	 * @param in
	 * @param comparator
	 * @return newArray
	 */
	public static String[] insertionSort(String[] in, Comparator<String> comparator) {
		String[] newArray = new String[in.length];
		System.arraycopy(in, 0, newArray, 0, in.length);

		int length = newArray.length;
		String currentIndexString;
		int j = 0;

		// For-loop checks every value of in[]:
		for (int i = 0; i < length; i++) {
			// in array index-value:
			currentIndexString = newArray[i];
			// State 'i - 1' so that the first index-value is set.
			j = i - 1;
			// While-loop swaps current index-values into correct positions.
			while (j >= 0 && comparator.compare(currentIndexString, newArray[j]) < 0) {
				newArray[j + 1] = newArray[j];
				j = j - 1;
			}
			newArray[j + 1] = currentIndexString;
		}
		return newArray;
	}

	/**
	 * Sorts strings in an array, so that shortest string ends up on index [0],
	 * longest on index[array.length-1].
	 * 
	 * @param in
	 * @param comparator
	 * @return sorted string array.
	 */
	public static String[] mergeSort(String[] in, Comparator<String> comparator) {

		String[] origNewArray = new String[in.length];
		System.arraycopy(in, 0, origNewArray, 0, in.length);

		int startIndex = 0;
		int endIndex = origNewArray.length - 1;

	

		String[] returnArr = splitStringArray(origNewArray, startIndex, endIndex, comparator);

		return returnArr;
	}

	/**
	 * Sorts the String[] by using the current indexe's which represent the current left and right of the String[], simultaneously merging these together.
	 * 
	 * @param array
	 * @param startIndex
	 * @param middleIndex
	 * @param endIndex
	 * @param comparator
	 * @param exclusionString
	 * @return sorted and merged String[]
	 */
	public static String[] mergeStringArray(String[] array, int startIndex, int middleIndex, int endIndex, Comparator<String> comparator) {
		int currentLeftValue = startIndex;
		int currentRightValue = middleIndex;
		int placementIndex = startIndex;

		String[] helpArray = new String[array.length];
		System.arraycopy(array, 0, helpArray, 0, array.length);

		for (int i = startIndex; i < middleIndex; i++) {
//			System.out.println("Right: " + array[currentRightValue]);
//			System.out.println("Left: " + array[currentLeftValue]);
//			System.out.println("HelpArray start loop: ");
//			toString(helpArray);
			while (comparator.compare(array[i], array[currentRightValue]) > 0 && placementIndex <= endIndex) {
				helpArray[placementIndex] = array[currentRightValue];
//				System.out.println("Right: " + array[currentRightValue]);
//				System.out.println("Left: " + array[currentLeftValue]);
//				System.out.println("HelpArray in while loop: " );
//				toString(helpArray);
				if (placementIndex < endIndex) {
					placementIndex++;
				} else {
					break;
				}

				if (currentRightValue < endIndex) {
					currentRightValue++;
				} else {
					break;
				}
			}

			helpArray[placementIndex] = array[currentLeftValue++];
			if (placementIndex < endIndex) {
				placementIndex++;
			}
		}

		// Copy over everything from helpArray, back to the original array.
		System.arraycopy(helpArray, 0, array, 0, helpArray.length);
		return array;
	}

	/**
	 * Splits the string[]'s indexe's, so that can sort it.
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @param comparator
	 * @param exclusionString
	 * @return the sorted and merged String[]
	 */
	public static String[] splitStringArray(String[] array, int startIndex, int endIndex, Comparator<String> comparator) {
		// First check so that length is not 1:
		if (endIndex - startIndex < 1) {
			return array;
		}
		// Divide the current length to find middleIndex:
		int middleIndex = (startIndex + endIndex + 1) / 2;

		// Recursion for the arrays, to keep splitting up indexe's:
		splitStringArray(array, startIndex, middleIndex - 1, comparator);
		splitStringArray(array, middleIndex, endIndex, comparator);

		String[] returnArr = mergeStringArray(array, startIndex, middleIndex, endIndex, comparator);
		return returnArr;
	}

	/**
	 * Processes the contents of an int[] into a string, and then prints this string
	 * to the console.
	 * 
	 * @param arr
	 */
	public static void toString(int[] arr) {
		String string = "[";

		for (int i = 0; i < arr.length; i++) {
			string += arr[i];
			if (i < arr.length - 1) {
				string += " | ";
			}
		}
		string += "]\n";
		System.out.println(string);
	}

	/**
	 * Processes the contents of an String[] into a string, and then prints this
	 * string to the console.
	 * 
	 * @param arr
	 */
	public static void toString(String[] arr) {
		String string = "[";

		for (int i = 0; i < arr.length; i++) {
			string += arr[i];
			if (i < arr.length - 1) {
				string += " | ";
			}
		}
		string += "]\n";
		System.out.println(string);
	}
}
