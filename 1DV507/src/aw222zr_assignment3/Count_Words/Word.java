package aw222zr_assignment3.Count_Words;

public class Word implements Comparable<Word> {

	private String wordString;

	public Word(String str) {
		wordString = str;
	}

	public String toString() {
		return wordString;
	}

	//Test att verkligen anv�nds.
	/* Override Object methods */
	@Override
	public int hashCode() {
		int hashCode = 0;
		for (int i = 0; i < wordString.length(); i++) {
			Character current = wordString.charAt(i);
			hashCode += Character.getNumericValue(current);
		}
		return hashCode;
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof Word) {
			Word otherWord = (Word) other;
			
			int test = this.compareTo(otherWord);
			if(test == 0) {
				return true;
			}
		}
		return false;
	}

	/* Implement Comparable */
	public int compareTo(Word word) {
		String callerString = wordString;
		String paraString = word.wordString;
		int numValue1 = 0;
		int numValue2 = 0;
		Character char1;
		Character char2;
		
		for (int i = 0; i < callerString.length() && i < paraString.length(); i++) {
			char1 = callerString.charAt(i);
			char2 = paraString.charAt(i);
			char1 = Character.toLowerCase(char1);
			char2 = Character.toLowerCase(char2);
			numValue1 += Character.getNumericValue(char1);
			numValue2 += Character.getNumericValue(char2);
			
			if (numValue1 > numValue2) {
				return 1;
			} else if (numValue2 > numValue1) {
				return -1;
			} else {
				continue;
			}
		}
		
		if (callerString.length() > paraString.length()) {
			return 1;
		} else if (callerString.length() < paraString.length()) {
			return -1;
		}
		return 0;
	}
}
