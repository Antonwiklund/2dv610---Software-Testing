package aw222zr_assignment1.intCollection;

public class ArrayIntList extends AbstractIntCollection implements IntList{
	
	public void add(int n) {
		values[size] += n;
		size++;
	}

	
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (super.checkIndex(index, size) == false) {
			throw new IndexOutOfBoundsException();
		}
		
		int[] replaceArray = new int[values.length];
		int j = 0;
		
		// Loop to add new integer, and move others to the right.
		for (int i = 0; i <= size; i++) {
			if (i != index) {
				replaceArray[i] = values[j++];
			} else if (i == index) {
				replaceArray[i] = n;
			}
		}
		// Copy replaceArray[] into values[].
		System.arraycopy(replaceArray, 0, values, 0, 4);
		// Add 1 to size, as now array size is larger.
		size++;
	}


	public void remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Can't remove value. No such index.");
		}
		// Make the index to remove 0, so know what to look for.
		values[index] = 0;
		
		// Loop for determining length of array to be copied from into values[]. 
		int length = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] != 0) {
				length++;
			}
		}
		
		// Loop to remove the 0 from the array.
		int[] replaceArray = new int[length];
		int j = 0;
		for (int i = 0; i <= length; i++) {
			if (values[i] != 0) {
				replaceArray[j++] = values[i];
			}
		}
		values = replaceArray;
		// Remove one from size, as values[] is smaller now.
		size--;
	}


	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int getInt = values[index];
		return getInt;
	}

	public int indexOf(int n) {
		// Loop for searching for the indexPos of n
		for (int i = 0; i < size; i++) {
			if (values[i] == n) {
				return i;
			}
		}
		return -1;
	}
	
	public void length() {
		int length = values.length;
		System.out.println("Length of array is: " + length);
	}
}
