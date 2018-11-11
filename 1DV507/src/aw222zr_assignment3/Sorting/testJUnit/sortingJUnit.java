package aw222zr_assignment3.Sorting.testJUnit;

import static org.junit.Assert.assertArrayEquals;

import java.util.Comparator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aw222zr_assignment3.Sorting.SortingAlgorithms;
import aw222zr_assignment3.Sorting.myComparator;

class sortingJUnit {

	@BeforeAll
	public static void setUpOnce(){
		System.out.println("Testing intialized:\n");
	}
	
	static int testNumber;
	
	@AfterAll
	public static void cleanUp() {
		System.out.println("Number of tests finished: " + (testNumber));
	}

	@BeforeEach
	public void beforeEach() {
		testNumber++;
		System.out.println("Test number " + testNumber + " is running...");
	}
	
	@AfterEach
	public void afterEach() {
		System.out.println("Test number " + (testNumber) + " has been run.\n");
	}
	
	// Test: insertionSort(int[])
	@Test
	void insertionIntSort() {
		new SortingAlgorithms();
		// Standard-case#1
		int[] testInt1 = {4, 2, 1, 3};
		int[] testInt11 = {1,2,3,4};
		assertArrayEquals(testInt11, SortingAlgorithms.insertionSort(testInt1));
		// Standard-case#2
		int[] testInt111 = {4, 2, 1, 3, 8, 1, 8};
		int[] testInt1111 = {1,1,2,3,4,8,8};
		assertArrayEquals(testInt1111, SortingAlgorithms.insertionSort(testInt111));
		// Extreme-case#low
		int[] testInt2 = {2, 1};
		int[] testInt22 = {1,2};
		assertArrayEquals(testInt22, SortingAlgorithms.insertionSort(testInt2));
		// Extreme-case#high
		int[] testInt3 = new int[10000];
		int[] testInt33 = new int[10000];
		for (int i = 1; i < testInt3.length; i++) {
			testInt3[i] = i;
			testInt33[i] = i;
		}
		testInt3[9999] = 1;
		testInt3[1] = 9999;
		assertArrayEquals(testInt33, SortingAlgorithms.insertionSort(testInt3));
	}

	// Test: mergeSort(in[])
	@Test
	void mergeSortIntTest() {
		new SortingAlgorithms();
		// Standard-case#1
		int[] testInt1 = {4, 2, 1, 3};
		int[] testInt11 = {1,2,3,4};
		assertArrayEquals(testInt11, SortingAlgorithms.mergeSort(testInt1));
		// Standard-case#2
		int[] testInt111 = {4, 2, 1, 3, 8, 1, 8};
		int[] testInt1111 = {1,1,2,3,4,8,8};
		assertArrayEquals(testInt1111, SortingAlgorithms.mergeSort(testInt111));
		// Extreme-case#low
		int[] testInt2 = {2, 1};
		int[] testInt22 = {1,2};
		assertArrayEquals(testInt22, SortingAlgorithms.mergeSort(testInt2));
		// Extreme-case#high
		int[] testInt3 = new int[10000];
		int[] testInt33 = new int[10000];
		for (int i = 1; i < testInt3.length; i++) {
			testInt3[i] = i;
			testInt33[i] = i;
		}
		testInt3[9999] = 1;
		testInt3[1] = 9999;
		assertArrayEquals(testInt33, SortingAlgorithms.mergeSort(testInt3));
	}
	
	@Test
	void mergeSortStringTest() {
		Comparator<String> myComp = new myComparator();
		new SortingAlgorithms();
		// Standard-case#1
		String[] testInt1 = {"4444", "22", "1", "333"};
		String[] testInt11 = {"1","22","333","4444"};
		assertArrayEquals(testInt11, SortingAlgorithms.mergeSort(testInt1, myComp));
		// Standard-case#2
		String[] testInt111 = {"4444", "22", "1", "333", "88888888", "1", "88888888"};
		String[] testInt1111 = {"1","1","22","333","4444","88888888","88888888"};
		assertArrayEquals(testInt1111, SortingAlgorithms.mergeSort(testInt111, myComp));
		// Extreme-case#small
		String[] testInt2 = {"22", "1"};
		String[] testInt22 = {"1","22"};
		assertArrayEquals(testInt22, SortingAlgorithms.mergeSort(testInt2, myComp));
		// Extreme-case#large
		String[] testInt3 = new String[10000];
		String[] testInt33 = new String[10000];
		for (int i = 1; i < testInt3.length; i++) {
			testInt3[i] = "i";
			testInt33[i] = "i";
		}
		testInt3[0] = "ii";
		testInt3[9999] = "";
		testInt33[9999] = "ii";
		testInt33[0] = "";
		assertArrayEquals(testInt33, SortingAlgorithms.mergeSort(testInt3, myComp));
	}
	
	@Test
	void insertionSortStringTest() {
		Comparator<String> myComp = new myComparator();
		new SortingAlgorithms();
		// Standard-case#1
		String[] testInt1 = {"4444", "22", "1", "333"};
		String[] testInt11 = {"1","22","333","4444"};
		assertArrayEquals(testInt11, SortingAlgorithms.insertionSort(testInt1, myComp));
		// Standard-case#2
		String[] testInt111 = {"4444", "22", "1", "333", "88888888", "1", "88888888"};
		String[] testInt1111 = {"1","1","22","333","4444","88888888","88888888"};
		assertArrayEquals(testInt1111, SortingAlgorithms.insertionSort(testInt111, myComp));
		// Extreme-case#small
		String[] testInt2 = {"22", "1"};
		String[] testInt22 = {"1","22"};
		assertArrayEquals(testInt22, SortingAlgorithms.insertionSort(testInt2, myComp));
		// Extreme-case#large
		String[] testInt3 = new String[10000];
		String[] testInt33 = new String[10000];
		for (int i = 1; i < testInt3.length; i++) {
			testInt3[i] = "i";
			testInt33[i] = "i";
		}
		testInt3[0] = "ii";
		testInt3[9999] = "";
		testInt33[9999] = "ii";
		testInt33[0] = "";
		assertArrayEquals(testInt33, SortingAlgorithms.insertionSort(testInt3, myComp));
	}
}
