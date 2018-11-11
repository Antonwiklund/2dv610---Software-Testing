package aw222zr_assignment3.Sorting;

import java.util.Comparator;

/**
 * Class for comparator.
 * @author Anton Wiklund
 *
 */
public class myComparator implements Comparator<String> {

	/**
	 * Comparator prioritizes the longest string when sorting.
	 * Compares two strings in the following way:
	 * If both are of equal length -> check for alphabetical order to sort.
	 * If both are of different length -> longest is placed on earlier index.
	 */
	public int compare(String string1, String string2) {
		
		if (string1.length() == string2.length()) {
			Character one = null;
			Character two = null;
			int oneVal = 0;
			int twoVal = 0;
			for (int i = 0;  i < string1.length(); i++) {
				one = string1.charAt(0);
				two = string2.charAt(0);
				oneVal = Character.getNumericValue(one);
				twoVal = Character.getNumericValue(two);
				if (oneVal > twoVal) {
					return 1;
				} else if (twoVal > oneVal) {
					return -1;
				} else {
					continue;
				}
			}
		} else {
			if (string1.length() > string2.length()) {
				return -1;
			} else if (string1.length() <= string2.length())
				return 1;
		}
		
		return 0;
	}

}
