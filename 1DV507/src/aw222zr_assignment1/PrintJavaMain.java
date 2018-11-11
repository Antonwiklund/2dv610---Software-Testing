package aw222zr_assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.Scanner;

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {
		File directory = new File(".");

		printAllJavaFiles(directory);
	}

	// printAllJavaFiles prints all the files(in the designated directory and its
	// sub-directories) ending with '.java'.
	public static void printAllJavaFiles(File directory) throws IOException {

		File[] directoryFiles = directory.listFiles();

		for (File file : directoryFiles) {
			if (file.isDirectory()) {
				// System.out.println("\nCurrent Directory: ");
				// System.out.println(file.getCanonicalPath());

				// calling printAllJavaFiles recursively. I.E, for every directory encountered,
				// we check for '.java' files.
				printAllJavaFiles(file);
			} else {
				if (globPattern(file) == true) {
					System.out.println("\nCurrent File: ");
					System.out.println(file.getName());
					countFileLines(file);
				}
			}
		}
	}

	// globPattern() checks whether current file is of the desired
	// program/class/etc.
	public static boolean globPattern(File file) {

		Path fileToPath = file.toPath();

		PathMatcher globMatcher = FileSystems.getDefault().getPathMatcher("glob:*.java");

		Path fileGlobTest = fileToPath.getFileName();

		if (globMatcher.matches(fileGlobTest)) {
			return true;
		}
		return false;
	}

	// countFileLines() counts the current files total number of lines.
	public static void countFileLines(File file) throws FileNotFoundException {
		Scanner scanFile = new Scanner(file);

		int counter = 0;

		while (scanFile.hasNextLine()) {
			scanFile.nextLine();
			counter++;

		}
		String current = file.getName();
		System.out.println("Total number of lines in '" + current + "':\n" + counter);
		scanFile.close();
	}
}
