package aw222zr_assignment3.Count_Words;

import java.util.Iterator;

/**
 * Class which represents a BinarySearchTree.
 * @author Anton Wiklund
 *
 */
public class TreeWordset implements WordSet{
	private TreeSet root = null;
	private int currentSize = 0;
	private int toStringCount = 0;
	private boolean instantiated = false;

	/**
	 * Adds specified Word to the BinarySearchTree.
	 */
	@Override
	public void add(Word word) {
		if (root == null) {
			root = new TreeSet(word);
			currentSize++;
		} else {
			root.add(word);
		}
	}
	
	/**
	 * Checks whether BinarySearchTree contains specified Word.
	 */
	@Override
	public boolean contains(Word word) {
		if (root == null) {
			return false;
		}
		return root.contains(word);
	}

	/**
	 * Prints the BinarySearchTree in alphabetical order.
	 */
	public void printLeaves() {
		if (root == null) {
			return;
		}
		root.printLeafs();
	}
	
	/**
	 * Returns an iterator, passing through the BinarySearchTree.
	 */
	@Override
	public Iterator<Word> iterator() {
		return root.getIt();
	}

	/**
	 * Returns the current size of the BinarySearchTree.
	 */
	@Override
	public int size() {
		return currentSize;
	}

	/**
	 * TreeSet is used in a similar way that a Node is used. 
 	 * Words are added to a 'TreeSet' and placed in the BinarySearchTree.
	 * @author Anton Wiklund
	 *
	 */
	private class TreeSet {
		Word leafWord;
		TreeSet left = null;
		TreeSet right = null;
		
		public TreeSet(Word word) {
			leafWord = word;
		}
		
		/**
		 * Add specified Word to the BST. 
		 * @param word
		 */
		private void add(Word word) {
			if (word.compareTo(leafWord) < 0) {
				if (left == null) {
					left = new TreeSet(word);
					currentSize++;
				} else {
					left.add(word);
				}
			} else if (word.compareTo(leafWord) > 0) {
				if (right == null) {
					right = new TreeSet(word);
					currentSize++;
				} else {
					right.add(word);
				}
			}
		}

		/**
		 * Checks whether BST contains the specified Word.
		 * @param word
		 * @return boolean
		 */
		private boolean contains(Word word) {
			if (word.compareTo(leafWord) < 0) {
				if (left == null) {
					return false;
				} else {
					return left.contains(word);
				}
			} else if (word.compareTo(leafWord) > 0) {
				if (right == null) {
					return false;
				} else {
					return right.contains(word);
				}
			}
			return true;
		}

		/**
		 * Prints the BST-Words in alphabetical order.
		 */
		private void printLeafs() {
			if (left != null) {
				left.printLeafs();
			}
			// If-statement formats the printing of the BST-words:
			if (instantiated == false) {
				System.out.println("\nAll the leaves printed, in alphabetical order: ");
				instantiated = true;
				System.out.print("[ ");
				System.out.print(leafWord.toString() + " | ");
				toStringCount++;
			} else if (currentSize-1 == toStringCount) {
				System.out.print(leafWord.toString());
				System.out.println(" ]\n");
			} else {
				if (toStringCount % 10 == 1 && toStringCount > 2) {
					System.out.println(leafWord.toString() + " | ");
				} else {
					System.out.print(leafWord.toString() + " | ");
				}
				toStringCount++;
			}

			if (right != null) {
				right.printLeafs();
			}
		}
		
		/**
		 * Returns iterator for the BinarySearchTree.
		 * @return BST Iterator.
		 */
		private TreeIterator getIt() {
			TreeIterator it = new TreeIterator(root);
			return it;
		}
	}
	
	/**
	 * Iterator which processes a BinarySearchTree, in alphabetical order.
	 * @author Anton Wiklund
	 *
	 */
	private class TreeIterator implements Iterator<Word> {
		
		TreeSet currentWord;

		public TreeIterator(TreeSet root) {
			currentWord = root;
			if (currentWord == null) {
				return;
			}
		}
		
		/**
		 * Checks if iterator has a next-value to return.
		 */
		@Override
		public boolean hasNext() {
			return currentWord != null;
		}

		/**
		 * Decides which 'currentWord' that is the next Word, in alphabetical order.
		 */
		@Override
		public Word next() {
			// thisWord is used to later reset 'currentWord' to the correct 'leafWord'. 'currentWord' is affected by every recursive call of next().
			TreeSet thisWord = currentWord;
			// 'leafIterated' makes sure that the 'leafWord' is only printed once.
			boolean leafIterated = false;
						
			// If left == null, print/do something with the current leaf value:
			if (currentWord.left == null) {
				System.out.println("Current leaf: " + currentWord.leafWord);
				leafIterated = true;
			}
			// If left != null, go left:
			if (currentWord.left != null) {
				currentWord = currentWord.left;
				next();
			}
			// Reset 'currentWord', so that it represent the correct leaf:
			currentWord = thisWord;
			// If the currentWord is the root:
			if (thisWord == root && leafIterated == false) {
				System.out.println("Current leaf: " + currentWord.leafWord);
				leafIterated = true;
			}
			// If right != null, print/do something with the current 'leafWord':
			if (currentWord.right != null && leafIterated == false) {
				System.out.println("Current leaf: " + currentWord.leafWord);
				leafIterated = true;
			}
			// If right != null, go right:
			if (currentWord.right != null) {
				currentWord = currentWord.right;
				next();
			}
			// Reset 'currentWord', so that it represent the correct leaf: 			
			currentWord = thisWord;
			// If 'thisWord' has not yet been used, then use 'thisWord':
			if (leafIterated == false) {
				System.out.println("Current leaf: " + currentWord.leafWord);
				leafIterated = true;
			}
			
			// BaseCase. If recursion has returned to 'root' after visiting right-side,
			// then cancel recursion. Does this by making currentWord == null: 
			if (currentWord == root) {
				Word complete = currentWord.leafWord;
				currentWord = null;
				return complete;
			}

			return currentWord.leafWord;
		}
	}
}
