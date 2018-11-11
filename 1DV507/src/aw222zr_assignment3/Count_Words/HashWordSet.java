package aw222zr_assignment3.Count_Words;

import java.util.Iterator;

/**
 * HashSet class for Word's.<br>
 * Allows the user to add Word's to a HashArray.<br>
 * User can also print HashArray to console, look for specific Word's, and iterate through Array.
 * @author Anton Wiklund
 *
 */
public class HashWordSet implements WordSet {

	private int currentHashArraySize = 0;
	private Node[] hashArray;
	private int hashModulus;

	public HashWordSet(int arrayLength) {
		if (arrayLength <= 0) {
			System.out.println("Enter length for array that is > 0");
			return;
		}
		hashArray = new Node[arrayLength];
		hashModulus = arrayLength;
	}

	/**
	 * Returns an Iterator<Word> for hashArray.
	 */
	public Iterator<Word> iterator() {
		HashIterator newIt = new HashIterator(hashArray);
		return newIt;
	}


	/**
	 * Adds a Word to the hashArray.
	 */
	public void add(Word word) {
		int index = (word.hashCode() % hashModulus);
		Node node = hashArray[index];

		// Check if the word already is present in hashArray:
		while (node != null) {
			if (node.currentWord.equals(word) == true) {
				return;
			} else {
				node = node.nextWord;
			}
		}

		// If not, create new Word and update various values:
		Node newNode = new Node(word);
		newNode.nextWord = hashArray[index];
		hashArray[index] = newNode;

		// If size of array = original length --> reHash():
		currentHashArraySize++;
		if (currentHashArraySize == hashArray.length) {
			reHash();
		}
	}

	/**
	 * Resize the hashArray when currentHashArraySize == hashArray.length.
	 */
	private void reHash() {
		Node[] tempArray = hashArray;
		hashArray = new Node[tempArray.length * 2];
		currentHashArraySize = 0;

		for (Node current : tempArray) {
			if (current == null) {
				continue;
			} else {
				if (current.currentWord == null) {
					continue;
				}
				while (current != null) {
					add(current.currentWord);
					current = current.nextWord;
				}
			}
		}
		hashModulus = hashArray.length;
	}

	/**
	 * Checks if the chosen Word already is to be found in the hashArray.
	 */
	public boolean contains(Word word) {
		// Find right index:
		int hashPosition = (word.hashCode() % hashModulus);
		Node node = hashArray[hashPosition];

		// Check for duplicate word:
		if (node != null) {
			if (node.currentWord.equals(word)) {
				return true;
			} else {
				node = node.nextWord;
			}
		}
		return false;
	}

	/**
	 * Returns current size of hashArray.
	 */
	public int size() {
		return currentHashArraySize;
	}
	
	/**
	 * Return a string-representation of the words in the HashSet.
	 */
	@Override
	public String toString() {
		Iterator<Word> it = iterator();
		System.out.println("\nAll the hashed words printed, in non alphabetical order:");
		String string = "[";
		int breakLine = 0;
		
		while (it.hasNext()) {
			string += it.next();
			string += " | ";
			breakLine++;
			
			if (breakLine >= 10) {
				string += "\n";
				breakLine = 0;
			}
		}
		string += "]\n";	
		return string;
	}

	/**
	 * Private class which creates a Node, to add the chosen Word to. Also has
	 * toString() functionality.
	 * 
	 * @author Anton Wiklund
	 */
	private class Node {
		Word currentWord;
		Node nextWord;

		public Node(Word add) {
			currentWord = add;
		}
	}

	/**
	 * Class for an iterator that traverses the HashArray.
	 * @author Anton Wiklund
	 *
	 */
	public class HashIterator implements Iterator<Word> {

		private Node[] array;
		private Node current;
		private int checkAllBuckets = 1;
		
		public HashIterator(Node[] hashArray) {
			array = hashArray;
			current = array[0];
		}

		/**
		 * Checks if HashArray has a next() value.
		 */
		public boolean hasNext() {
			while (current == null && checkAllBuckets < hashArray.length) {
				current = array[checkAllBuckets];
				checkAllBuckets++;
			}
			if (current != null) {
				return true;
			}
			return false;
		}

		/**
		 * Returns the correct next-value.
		 */
		public Word next() {
			if (current != null) {
				Word returnWord = current.currentWord;
				Node deleteNextLink = current;
				current = current.nextWord;
				deleteNextLink.nextWord = null;
				
				return returnWord;
			}
			return null;
		}

	}

}
