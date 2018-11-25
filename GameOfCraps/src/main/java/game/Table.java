package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {

	// ArrayList's for players at table.
	ArrayList<Player> playerArray = new ArrayList<Player>();
	ArrayList<Award> awardsArray = new ArrayList<Award>();
	ArrayList<Integer> resultsArray = new ArrayList<Integer>();
	ArrayList<ArrayList> mergedArray = new ArrayList<ArrayList>();
	
	/*
	 * Starts the game. Provides a console-UI, in which it can be chosen how many
	 * players should play. Also creates a fixed-sized array in response to this.
	 */
	public int welcomeToTable() throws IOException {

		System.out.println("Welcome to this dicegame.\n"
				+ "\n In order to choose between the options below, enter the respective number."
				+ "\n 1) ReadMe introduction to program." + "\n 2) Enter number of players, and start the game."
				+ "\n 3) Quit game.");

		int numberOfPlayers = 0;
		int tries = 0;
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		while (choice <= 0 || choice > 3) {
			System.out.println("Invalid input. Try again, or enter '-1' to exit program.");
			choice = in.nextInt();

			if (choice == -1) {
				System.exit(1);
			}
			tries++;
			if (tries == 10) {
				System.out.println("Too many tries. System exit.");
				System.exit(1);
			}
		}

		// This part of the code reads the ReadMe.txt, and outputs it to the console.
		Scanner in2 = new Scanner(System.in);
		if (choice == 1) {
			String source = "/home/anton/eclipse-workspace/GameOfCraps/src/ReadMe.txt";
			String nextLine;

			FileReader fileReader = new FileReader(source);

			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((nextLine = bufferedReader.readLine()) != null) {
				System.out.println(nextLine);
			}
			bufferedReader.close();
			
			System.out.println("\n\nAfter having read the ReadMe:"
					+ "\n In order to choose between the options below, enter the respective number."
					+ "\n 2) Enter number of players, and start the game." + "\n 3) Quit game.");

			int tries2 = 0;
			choice = in2.nextInt();
			while (choice <= 1 || choice > 3) {
				choice = in2.nextInt();
				System.out.println("Invalid input. Try  again, or enter '-1' to exit program.");
				tries2++;
				if (tries2 == 10) {
					System.out.println("Too many tries. System exit.");
					System.exit(1);
				}
			}
		}
		if (choice == 2) {
			System.out.println("Enter number of players:");
			Scanner in3 = new Scanner(System.in);
			int numberOfPlayersScanned = in3.nextInt();
			in3.close();
			numberOfPlayers = numberOfPlayersScanned;
		} else if (choice == 3) {
			System.out.println("Game shutting down.");
			System.exit(1);
		}
		in.close();
		in2.close();
		return numberOfPlayers;
	}

	/*
	 * add player to the playerArray.
	 * Max 8 players.
	 */
	public void importPlayer(Player player) {
		if (playerArray.size() == 8) {
			System.out.println("Maximum of 8 players. Game already full.");
			return; // write separate test.
		}
		playerArray.add(player);
	}
	
	/*
	 * allows players to place bets.
	 */
	public void placeBets(ArrayList<Player> playerList) {
		for (int i = 0; i < playerList.size(); i++) {
			Player currentPlayerToSetBet = playerList.get(i);
			currentPlayerToSetBet.setBetOne();
			currentPlayerToSetBet.setBetTwo();
		}
	}
	
	/*
	 * allows to return player's bets.
	 */
	public int getBetsValue(Player player) {
		return player.getBetOne() + player.getBetTwo();
	}
		
	/*
	 * return the playerArray.
	 */
	public ArrayList<Player> getPlayerArray() {
		return playerArray;
	}
	
	/*
	 * return the awardsArray.
	 */
	public ArrayList<Award> getAwardsArray() {
		return awardsArray;
	}
	
	/*
	 * return the resultsArray.
	 */
	public ArrayList<Integer> getResultsArray() {
		return resultsArray;
	}
	
	/*
	 * Merges playersArray,awardsArray,resultsArray.
	 */
	public ArrayList<ArrayList> mergeArrays() {
			mergedArray.add(playerArray);
			mergedArray.add(awardsArray);
			mergedArray.add(resultsArray);
			return mergedArray;
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
