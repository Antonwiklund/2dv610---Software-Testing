package aw222zr_assignment3.Count_Words;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class IdentifyWordsMain {

	/**
	 * Transfers, from an existing File into a new File, all characters == white-space and letter:
	 * @param args
	 */
	public static void main(String[] args) {
		File fileToCountWords = new File("C:\\Users\\Ej Admin\\Dropbox\\Eclipse Windows\\1DV507\\src\\aw222zr_assignment3\\HistoryOfProgramming.txt");
		File returnFile = new File("word.txt");
		try {
			File text = processString(fileToCountWords);
			System.out.println(text);
			int total = 0;
			Scanner wordFileScanner = new Scanner(text);
			while (wordFileScanner.hasNext()) {
				System.out.println(wordFileScanner.next());
				total++;
			}
			System.out.println(total);
			wordFileScanner.close();
			returnFile = text;
			System.out.println(returnFile.getAbsolutePath());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Word test = new Word("ABCF");
		Word test2 = new Word("ABCD");

		System.out.println("Commpare" + test2.compareTo(test));

		System.out.println(test.hashCode() % 10);
	}

	private static File processString(File args) throws IOException {
		
		File wordFile = new File("word.txt");
		FileWriter FW = new FileWriter(wordFile);
		BufferedWriter BW = new BufferedWriter(FW);
		Scanner argsScanner = new Scanner(args);
		
		while (argsScanner.hasNextLine()) {
			String checkCurrentLine = argsScanner.nextLine();
			Character currentChar;
			String writeToWord = " ";
			for (int i = 0; i < checkCurrentLine.length(); i++) {
				currentChar = checkCurrentLine.charAt(i);
			
				// So that last word in line is also added:
				if (currentChar == '.') {
					BW.write(writeToWord);
					writeToWord = "";
				}
				// Decides which of the characters that shall be added to the word:
				if(Character.isLetter(currentChar) == true || Character.isWhitespace(currentChar)) {
					writeToWord += currentChar;
					if (Character.isWhitespace(currentChar)) {
						BW.write(writeToWord);
						writeToWord = "";
					}	
				}
			}
		}
		argsScanner.close();
		BW.close();
		
		return wordFile;
	}
}
