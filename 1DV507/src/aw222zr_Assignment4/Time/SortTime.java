package aw222zr_Assignment4.Time;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import aw222zr_Assignment4.Time.Sort.SortingAlgorithms;
import aw222zr_Assignment4.Time.Sort.myComparator;

/**
 * Measures time for various sort-methods to finish.
 * 
 * @author Anton Wiklund
 *
 */

public class SortTime {

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
		Random random = new Random();
		Comparator<String> comparator = new myComparator();
		int[] intArray;
		String[] stringArray;
		long beforeConcatenation;
		long afterConcatenation;
		long timeForConcatenation;
		double seconds;
		String print;

		for (int k = 0; k < 5; k++) {
			System.out.println("\nTest-round number: " + (k + 1));

			System.out.println("InsertionSort for int: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Round: " + j);
				intArray = new int[100000];
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < intArray.length; i++) {
					intArray[i] = random.nextInt(10000000) + 1;
				}
				SortingAlgorithms.insertionSort(intArray);
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for insertionSort(integer) to finish): " + print);
				System.out.println("Final int[] length: " + intArray.length + "\n");
				// Run garbagecollector after every test, to give next test a fresh start:
				Runtime.getRuntime().gc();
			}

			System.out.println("InsertionSort for String: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Round: " + j);
				stringArray = new String[31000];
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < stringArray.length; i++) {
					String randomString = "";
					for (int h = 0; h < 10; h++) {
						int randomNumber = random.nextInt(1000) + 1;
						randomString += Character.toString((char) randomNumber);
					}
					stringArray[i] = randomString;
				}
				SortingAlgorithms.insertionSort(stringArray, comparator);
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for insertionSort(String) to finish): " + print);
				System.out.println("Final String[] length: " + stringArray.length + "\n");
				Runtime.getRuntime().gc();
			}

			System.out.println("MergeSort for Int: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Round: " + j);
				intArray = new int[30000];
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < intArray.length; i++) {
					intArray[i] = random.nextInt(10000000) + 1;
				}
				SortingAlgorithms.mergeSort(intArray);
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for mergeSort(integer) to finish): " + print);
				System.out.println("Final string length: " + intArray.length + "\n");
				Runtime.getRuntime().gc();
			}

			System.out.println("MergeSort for String: ");
			for (int j = 1; j <= numberOfTests; j++) {
				System.out.println("Round: " + j);
				stringArray = new String[29000];
				beforeConcatenation = System.nanoTime();
				for (int i = 0; i < stringArray.length; i++) {
					String randomString = "";
					for (int h = 0; h < 10; h++) {
						int randomNumber = random.nextInt(1000) + 1;
						randomString += Character.toString((char) randomNumber);
					}
					stringArray[i] = randomString;
				}
				SortingAlgorithms.mergeSort(stringArray, comparator);
				afterConcatenation = System.nanoTime();
				timeForConcatenation = (afterConcatenation - beforeConcatenation);
				seconds = timeForConcatenation / 1000000000.0;
				print = dfSeconds.format(seconds);
				System.out.println("Time for mergeSort(String) to finish): " + print);
				System.out.println("Final String[] length: " + stringArray.length + "\n");
				Runtime.getRuntime().gc();
			}
		}
	}

}
