package aw222zr_Assignment4.Time;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Measures the time it takes to append/concatenate various lengths of strings.
 * 
 * @author Anton Wiklund
 *
 */
public class ConcatenationTime {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.println(
				"Choose the number of test-iterations you want to run. !Observe: Recommended number of tests: Minimum 15! (Only integers > 0) :");
		int numberOfTests = in.nextInt();
		while (numberOfTests <= 0) {
			System.out.println("No integers <= 0. Enter positive integer. To exit program, enter '-1'.");
			numberOfTests = in.nextInt();
			if (numberOfTests == -1) {
				System.exit(1);
			}
		}
		in.close();

		DecimalFormat dfSeconds = new DecimalFormat("#.##");
		// String to decide number of testruns:
		for (int k = 0; k < 10; k++) {
			System.out.println("\nTest-round number: " + (k + 1));
			StringBuilder sb = new StringBuilder();
			double seconds;
			String print;
			long beforeConcatenation;
			long afterConcatenation;
			long timeForConcatenation;
			String concat = null;
			String sbString;

			System.out.println("Appendation-time for single-char: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Test #: " + j);
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < 105000000; i++) {
					sb.append("a");
				}
				sbString = sb.toString();
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for single-character-string-appendation to finish(StringBuilder): " + print);
				System.out.println("Final string length: " + sbString.length() + "\n");
				// Run garbagecollector after every test, to give next test a fresh start:
				Runtime.getRuntime().gc();
				// Reset SB:
				sb.setLength(0);
			}

			System.out.println("Appendation-time for 80-char-string: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Test #: " + j);
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < 10500000; i++) {
					sb.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
				}
				sbString = sb.toString();
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for 80-character-string-appendation to finish(StringBuilder): " + print);
				System.out.println("Final string length: " + sbString.length() + "\n");
				sb.setLength(0);
				Runtime.getRuntime().gc();
			}

			System.out.println("Concatenation-time for 1-char-string: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Test #: " + j);
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < 72000; i++) {
					concat += "a";
				}
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for 1-character-string-concatenation to finish(String): " + print);
				System.out.println("Final string length: " + (concat.length()) + "\n");
				concat = "";
				Runtime.getRuntime().gc();
			}

			System.out.println("Concatenation-time for 80-char-string: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Test #: " + j);
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < 7300; i++) {
					concat += "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
				}
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for 80-character-string-concatenation to finish(String): " + print);
				System.out.println("Final string length: " + (concat.length()) + "\n");
				concat = "";
				Runtime.getRuntime().gc();
			}
		}
	}

}
