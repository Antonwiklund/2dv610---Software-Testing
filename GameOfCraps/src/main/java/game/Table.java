package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Table {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Starts the game. Provides a console-UI, in which it can be chosen how many players should play.
	 * Also creates a fixed-sized array in response to this.
	 */
	public Player[] welcomeToTable() throws IOException {
		
		System.out.println("Welcome to this dicegame."
				+ "\n In order to choose between the options below, enter the respective number."
				+ "\n 1) ReadMe introduction to program."
				+ "\n 2) Enter number of players, and start the game."
				+ "\n 3) Quit game.");
		
		int tries = 0;
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		while (choice <= 0 || choice > 3) {
		System.out.println("Invalid length of name. Enter 2-20 letters. To exit program, enter only 1 letter.");
		choice = in.nextInt();
		System.out.println(choice);
		if (choice == -1) {
			System.exit(1);
		}
		tries++;
		if (tries == 10) {
			System.out.println("Too many tries. System exit.");
		} in.close();
	}
		
		Player[] playerArray = null;
		if(choice == 1) {
			String source = "/home/anton/eclipse-workspace/GameOfCraps/src/ReadMe.txt";
			String nextLine;
		
            FileReader fileReader = new FileReader(source);
          
          
			BufferedReader bufferedReader = new BufferedReader(fileReader);
		
            while((nextLine = bufferedReader.readLine()) != null) {
                System.out.println(nextLine);
            }
      ;
            bufferedReader.close();
            System.out.println("\n\nAfter having read the ReadMe:"
    				+ "\n In order to choose between the options below, enter the respective number."
    				+ "\n 2) Enter number of players, and start the game."
    				+ "\n 3) Quit game.");
            
    		int tries2 = 0;
    		Scanner in3 = new Scanner(System.in);
    		choice = in3.nextInt();
    		while (choice <= 1 || choice > 3) {
    			choice = in3.nextInt();
    			tries2++;
    		if (tries2 == 10) {
    			System.out.println("Too many tries. System exit.");
    		} in3.close();
    	}
		} 
		if(choice == 2) {
			System.out.println("Enter number of players:");
			Scanner in2 = new Scanner(System.in);
			int numberOfPlayers = in2.nextInt();
			in2.close();
			playerArray = new Player[numberOfPlayers];
		} else if(choice == 3) {
			System.out.println("Game shutting down.");
			System.exit(1);
		}
		
		return playerArray;
	}

	/*
	 * Provides an 'int' value from 1-6.
	 */
	public int rollDice() {
		Random random = new Random();
		int diceValue = 1 + random.nextInt(6);
		return diceValue;
	}
	
}
