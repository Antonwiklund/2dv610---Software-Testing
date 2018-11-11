package aw222zr_assignment3.Count_Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class WordCount1Main {

	static int addedToHash = 0;
	static int addedToTree = 0;
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		File wordFile = new File("C:\\Users\\Ej Admin\\Dropbox\\Eclipse Windows\\1DV507\\word.txt");
		HashSet<Word> hash = new HashSet<Word>();
		TreeSet<Word> tree = new TreeSet<Word>();
		
		// Add File to Scanner:
		Scanner wordScanner = new Scanner(System.in);
		try {
			wordScanner = new Scanner(wordFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Scan for words, and add to set's:
		while (wordScanner.hasNext()) {
			String nextString = wordScanner.next();
			Word newWord = new Word(nextString);
			hash.add(newWord);
			tree.add(newWord);
		}
		wordScanner.close();
		
		// Count words in hashSet:
		Iterator<Word> hashIt = hash.iterator();
		hashString(hashIt);

		// Count words in treeSet:
		Iterator<Word> treeIt = tree.iterator();
		treeString(treeIt);
	
		System.out.println("\nTotal number of words in hashSet:" + addedToHash);
		System.out.println("Total number of words in treeSet:" + addedToTree);
	}
	
	private static void treeString(Iterator<Word> tree) {
		System.out.println("\nWords in BST, sorted alphabetically: ");
		String print = "[";
		int count = 0;
		while (tree.hasNext()) {
			print += tree.next();
			addedToTree++;
			if (tree.hasNext() == true) {
				print += " | ";
			}
			count++;
			if (count == 15) {
				print += "\n";
				count = 0;
			}
		}
		print += "]";
		System.out.println(print);
	}
	
	private static void hashString(Iterator<Word> hash) {
		System.out.println("\nWords in HashArray: ");
		String print = "[";
		int count = 0;
		while (hash.hasNext()) {
			print += hash.next();
			addedToHash++;
			if (hash.hasNext() == true) {
				print += " | ";
			}
			count++;
			if (count == 15) {
				print += "\n";
				count = 0;
			}
		}
		print += "]";
		System.out.println(print);
	}
}
