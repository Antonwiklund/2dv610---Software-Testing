package aw222zr_assignment3.Sorting;

import java.util.Comparator;

public class SortingAlgorithmsMain {
	
	public static void main(String[] args) {
		// Enter input to array:		
		int[] testIntArray = new int[26];
		for(int i = 0; i < testIntArray.length; i++) {
			testIntArray[i] = i;
		}
		// Change input, so can test if the algorithms sorts correctly.
		testIntArray[0] = -900;
		testIntArray[3] = 500;
		testIntArray[2] = -1;
		testIntArray[1] = 2;
		testIntArray[9] = -200;
		testIntArray[5] = 400;
		testIntArray[7] = 9000;
		testIntArray[8] = -50;
		testIntArray[10] = -9005;
		testIntArray[13] = 5500;
		testIntArray[12] = 11111;
		testIntArray[11] = 221;
		testIntArray[19] = 150;
		testIntArray[15] = 460;
		testIntArray[17] = 9900;
		testIntArray[18] = 44;
		testIntArray[20] = 11112;
		testIntArray[21] = 222;
		testIntArray[22] = 151;
		testIntArray[23] = 461;
		testIntArray[24] = 9910;
		testIntArray[25] = 45;
		
		// Test insertionSort for int[]:
		int[] testt = SortingAlgorithms.insertionSort(testIntArray);
		SortingAlgorithms.toString(testt);
		
		// Test insertionSort for String[]:
		String[] testStringArray = {"BeerBeerBeer", "Jest", "VariousPeople", "vww", "www", "CuriousPeople", "BiggestBear", "a", "k", "best", "d", "c"};
		Comparator<String> testComp = new myComparator();
		String[] insertionString = SortingAlgorithms.insertionSort(testStringArray, testComp);
		SortingAlgorithms.toString(insertionString);
		
		// Test mergeSort for int[]:
		int[] testtt = SortingAlgorithms.mergeSort(testIntArray);
		SortingAlgorithms.toString(testtt);
		
		// Test mergeSort for String[]:
		String[] mergeString = SortingAlgorithms.mergeSort(testStringArray, testComp);
		SortingAlgorithms.toString(mergeString);
	}
}
