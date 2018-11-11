package aw222zr_exam;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println("Enter string you want to check for palindrome:");
		String checkIfPalindrome = in.nextLine();
		in.close();

		boolean palindrome = checkPalindrome(checkIfPalindrome);

		System.out.println("The input '" + checkIfPalindrome + "' is a palindrome: " + palindrome);
	}

	/**
	 * Checks if a string is a palindrome.
	 * 
	 * @param string
	 * @return palindrome
	 */
	private static boolean checkPalindrome(String string) {

		String processedString = "";
		boolean palindrome = true;

		// Swap all characters to lower-case, and remove non-letters:
		for (int i = 0; i < string.length(); i++) {
			Character current = string.charAt(i);
			if (Character.isLetter(current)) {
				Character currentLowerCase = Character.toLowerCase(current);
				processedString += currentLowerCase;
			}
		}

		// Check characters against each other.
		for (int i = 0; i < processedString.length(); i++) {
			char leftSide = processedString.charAt(i);
			char rightSide = processedString.charAt(processedString.length() - i - 1);
			if (leftSide != rightSide) {
				palindrome = false;
				break;
			}
		}
		return palindrome;
	}

}
