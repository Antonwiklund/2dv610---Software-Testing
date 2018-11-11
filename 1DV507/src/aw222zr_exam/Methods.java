package aw222zr_exam;

import java.util.ArrayList;

public class Methods {

	public static void main(String[] args) {

		// Create ArrayList and fill it with integers:
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			primeList.add(i);
		}
		// Count the prime-numbers in primeList:
		System.out.println("Occurences of primenumbers in the list: " + countPrimeNumbers(primeList) + "\n");

		// Create array to test for strict increase, to get a 'true' return-value:
		int[] increasingArray = new int[6];
		for (int i = 0; i < increasingArray.length; i++) {
			increasingArray[i] = i + 1;
		}
		System.out.println("Array is strictly increasing: " + isStrictlyIncreasing(increasingArray));

		// Change one integer in array in order to break strict increase, to get a
		// 'false' return-value:
		increasingArray[3] = 0;
		System.out.println("\nArray is strictly increasing: " + isStrictlyIncreasing(increasingArray));
	}

	/**
	 * Checks the number of prime-numbers in an ArrayList.
	 * 
	 * @param list
	 * @return occurencesOfPrime
	 */
	// Kollade på internet vad ett primtal är och hur man matematiskt beräknar.
	// Kollade ingen kod.
	private static int countPrimeNumbers(ArrayList<Integer> list) {
		// Start with designating the total amount of elements in the list as being
		// potential prime-numbers.
		// Those who aren't prime will in the while-loop incur deduction to
		// 'occurencesOfPrime'.
		int occurencesOfPrime = list.size() - 1;

		// Calculate which of the numbers in the ArrayList that are prime-numbers.
		for (int i = 0; i < list.size(); i++) {
			int startDivision = 2;
			double checkForPrime = list.get(i);
			double squareRoot = Math.sqrt(checkForPrime);

			while (startDivision <= squareRoot) {
				double afterDivide = checkForPrime / startDivision;

				if (testPrime(afterDivide) == false) {
					occurencesOfPrime--;
					break;
				}
				startDivision++;
			}
		}
		return occurencesOfPrime;
	}

	/**
	 * Processed currentDouble so that can decide if is a prime-number.
	 * 
	 * @param currentDouble
	 * @return boolean
	 */
	private static boolean testPrime(double currentDouble) {
		boolean isPrimeNumber = true;
		String testDouble = Double.toString(currentDouble);
		Character getChar = testDouble.charAt(2);
		int getInt = Character.getNumericValue(getChar);

		if (getInt == 0) {
			isPrimeNumber = false;
		}

		return isPrimeNumber;
	}

	/**
	 * Checks whether the integers in an int[] are increasing in value per every
	 * index-value.
	 * 
	 * @param arr
	 * @return strictlyIncreasing
	 */
	private static boolean isStrictlyIncreasing(int[] arr) {

		boolean strictlyIncreasing = false;

		// Check if the current index-value is smaller than the next index-value:
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				strictlyIncreasing = true;
			} else {
				strictlyIncreasing = false;
				break;
			}
		}

		return strictlyIncreasing;
	}
}
