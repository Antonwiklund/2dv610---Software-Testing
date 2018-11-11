package aw222zr_assignment3.Count_Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCount2Main {

	@SuppressWarnings("resource") 
	public static void main(String[] args) {
		File wordFile = new File("C:\\Users\\Ej Admin\\Dropbox\\Eclipse Windows\\1DV507\\word.txt");
		HashWordSet hashSet = new HashWordSet(16);
		TreeWordset treeSet = new TreeWordset();
		// Scan File for Word's:
		Scanner wordScanner = new Scanner(System.in);
		try {
			wordScanner = new Scanner(wordFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// Add Word's to set's:
		while (wordScanner.hasNext()) {	
			String nextString = wordScanner.next();
			Word newWord = new Word(nextString);
			hashSet.add(newWord);
			treeSet.add(newWord);
		}
		wordScanner.close();
		
		// Test the hash-iterator:
		Iterator<Word> testIt1 = hashSet.iterator();
		while (testIt1.hasNext()) {
			testIt1.next();
		}
		
		// Test the tree-iterator:
		// Yes, I realize I made a complete mistake with this implementation... I just realized sunday evening and there is no time to rewrite it before deadline. 
		Iterator<Word> testIt2 = treeSet.iterator();
		while (testIt2.hasNext()) {
			System.out.println("Iterator: ");
			testIt2.next();
		}		
						
		// Print the set's to console:
		treeSet.printLeaves();
		System.out.println(hashSet.toString());
		System.out.println("\nTotal number of words in hashSet:" + hashSet.size());
		System.out.println("Total number of words in treeSet:" + treeSet.size());
		
		// Check if set's contain the specified word:
		Word testWord = new Word("ADD");
		System.out.println("\nTreeSet contains the test-Word: " + treeSet.contains(testWord));
		System.out.println("HashSet contains the test-Word: " + hashSet.contains(testWord));
	}			
}
