package game;

import java.util.Scanner;

public class Award {
	
	String value;
	
	/*
	 * Constructor for Award.
	 */
	public Award() {
		Scanner in = new Scanner(System.in);	
		System.out.println("Enter, as a string, the type of Award.");
		this.value = in.nextLine();
		in.close();
	}
	
	/*
	 * Returns the value of object.
	 */
	public String getValue() {
		String returnString = value;
		return returnString;
	}

}
