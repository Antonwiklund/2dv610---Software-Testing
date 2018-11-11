package aw222zr_assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Class for counting the number of unique words in a file.txt
 * @author Anton Wiklund
 *
 */
public class WarAndPeace {

	/**
	 * Counts the number of unique words in a text-file.
	 * @param args
	 */
	public static void main(String[] args) {
		File book = new File("C:\\Users\\Ej Admin\\Dropbox\\Eclipse Windows\\1DV507\\src\\aw222zr_assignment1\\WarAndPeace.txt");
		String words = "";
		try {
			words = bookWordsCount(book);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String[] wordsArray = words.split(" ");
		System.out.println("Initial word count: "+wordsArray.length);
		
		
		List<String> streamBook = Arrays.asList(wordsArray);
		long numberOfUniqueWords = streamBook
			.stream()
			.map(s -> removeChars(s))
			.map(String :: toUpperCase)
			.filter(s -> s.length() > 0)
			.distinct()
			.count();
		System.out.println("\nUnique word count: " + numberOfUniqueWords);			
	}

	/**
	 * Checks a String for certain characters. Returns an, if necessary, adjusted String.
	 * @param current
	 * @return
	 */
	public static String removeChars(String current) {
		String returnString = "";
		Character currentChar = null;
		
		for (int i = 0; i < current.length(); i++) {
			currentChar = current.charAt(i);
			if (Character.isLetter(currentChar) || currentChar == '-' || currentChar == '\'') {
				returnString += current.charAt(i);
			}
		}	
		return returnString;
	}
	
	/**
	 * Takes a file as parameter, creates a string out of it, and returns this string.
	 * @param book
	 * @return
	 * @throws FileNotFoundException
	 */
	private static String bookWordsCount(File book) throws FileNotFoundException {
		String returnString = "";
		StringBuilder test = new StringBuilder();
		Scanner in = new Scanner(book);

		while (in.hasNext()) {
			test.append(in.next() + " ");
		}
		returnString = test.toString();
		in.close();
		return returnString;
	}

}
