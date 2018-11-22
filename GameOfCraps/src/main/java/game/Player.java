package game;

import java.util.Scanner;

public class Player {
	
	private String playerFirstName;
	private String playerLastName;
	private int playerAge;
	
	/*
	 * Constructor which initiates Player class. User enters information about him/herself.
	 */
	public Player() {
		
		int tries = 0;
		System.out.println("Enter your first name:");
		Scanner in = new Scanner(System.in);
		String firstName = in.nextLine();
		while (firstName.length() <= 1 || firstName.length() > 20) {
			System.out.println("Invalid length of name. Enter 2-20 letters. To exit program, enter only 1 letter.");
			firstName = in.nextLine();
			System.out.println(firstName);
			if (firstName.length() == 1) {
				System.exit(1);
			}
			tries++;
			if (tries == 10) {
				System.out.println("Too many tries. System exit.");
			}
		}
		
		System.out.println("Enter your last name:");
		String lastName = in.nextLine();
		while (lastName.length() <= 1 || lastName.length() > 20) {
			System.out.println("Invalid length of name. Enter 2-20 letters. To exit program, enter only 1 letter.");
			lastName = in.nextLine();
			if (lastName.length() == 1) {
				System.out.println("test");
				System.exit(1);
			}
			tries++;
			if (tries == 10) {
				System.out.println("Too many tries. System exit.");
			}
		}
		
		System.out.println("Enter your age:");
		int age = in.nextInt();
		while (age <= 0 || age > 120) {
			System.out.println("You can't be that age(but if you really are, contact us and we will manually"
					+ " enter you into a game). Enter real age. To exit program, enter '-1'.");
			age = in.nextInt();
			if (age == -1) {
				System.exit(1);
			}
			tries++;
			if (tries == 10) {
				System.out.println("Too many tries. System exit.");
			}
		}
		
		in.close();
		
		this.playerAge = age;
		this.playerFirstName = firstName;
		this.playerLastName = lastName;
	}
	
}
