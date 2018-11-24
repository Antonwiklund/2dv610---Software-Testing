package game;

import java.util.Scanner;

public class Player {
	
	private String playerFirstName;
	private String playerLastName;
	private int playerAge;
	private int currentTotalResult;
	private int betOne;
	private int betTwo;
	
	/*
	 * Constructor which initiates Player class. User enters information about him/herself.
	 */
	public Player() {
		
		int tries = 0;
		System.out.println("Enter your first name:");
		Scanner in = new Scanner(System.in);
		String firstName = "an";
//		while (firstName.length() <= 1 || firstName.length() > 20) {
//			System.out.println("Invalid length of name. Enter 2-20 letters. To exit program, enter only 1 letter.");
//			firstName = in.nextLine();
//			System.out.println(firstName);
//			if (firstName.length() == 1) {
//				System.exit(1);
//			}
//			tries++;
//			if (tries == 10) {
//				System.out.println("Too many tries. System exit.");
//			} in.close();
//		}
		
		System.out.println("Enter your last name:");
		String lastName = "ant";
//		while (lastName.length() <= 1 || lastName.length() > 20) {
//			System.out.println("Invalid length of name. Enter 2-20 letters. To exit program, enter only 1 letter.");
//			lastName = in.nextLine();
//			if (lastName.length() == 1) {
//				System.out.println("test");
//				System.exit(1);
//			}
//			tries++;
//			if (tries == 10) {
//				System.out.println("Too many tries. System exit.");
//			} in.close();
//		}
		
		System.out.println("Enter your age:");
		int age = 5;
//		while (age <= 0 || age > 120) {
//			System.out.println("You can't be that age(but if you really are, contact us and we will manually"
//					+ " enter you into a game). Enter real age. To exit program, enter '-1'.");
//			age = in.nextInt();
//			if (age == -1) {
//				System.exit(1);
//			}
//			tries++;
//			if (tries == 10) {
//				System.out.println("Too many tries. System exit.");
//			} in.close();
//		}
		
		this.playerAge = age;
		this.playerFirstName = firstName;
		this.playerLastName = lastName;
	}
	
	/*
	 * Adds player's result to currentTotalResult.
	 */
	public void addToResult(int current) {
		this.currentTotalResult += current;
		System.out.println(currentTotalResult);
	}
	
	/*
	 * Get player's currentTotalResult.
	 */
	public int getCurrentResult() {
		return currentTotalResult;
	}
	
	public void setBetOne() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter bet one:");
		this.betOne = in.nextInt();
		in.close();
	}
	
	public void setBetTwo() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter bet two:");
		this.betTwo = in.nextInt();
		in.close();
	}
	
	public int getBetOne() {
		return betOne;
	}
	
	public int getBetTwo() {
		return betTwo;
	}
}
