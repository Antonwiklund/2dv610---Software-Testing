package game;

import java.util.Scanner;

public class Award {
	
	String value;
	
	public void createAward() {
		Scanner in = new Scanner(System.in);	
		System.out.println("Enter the String-value of the Award");
		this.value = in.nextLine();
		in.close();
	}
	
	public String getValue() {
		String returnString = value;
		return returnString;
	}

}
