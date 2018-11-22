package game;

import java.util.Scanner;

public class Player {
	
	private String playerName;
	private int playerAge;
	
	public Player() {
		
		System.out.println("Enter your first name:)");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		System.out.println("Enter your age:)");
		int age = in.nextInt();
		
		in.close();
		
		this.playerAge = age;
		this.playerName = name;
	}
	
}
