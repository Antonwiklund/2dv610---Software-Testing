package aw222zr_Assignment2.javaFX;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class for playing a round of the game 'Yahtzee'.
 * Methods in this class has the following functionalities:
 * start(): sets up layout and instantiates playYahtzee().
 * playYahtzee(): starts the program for a round of Yahtzee.
 * countResult(): counts the result of the held dice's.
 * resultText(): sets the text which should be displayed at end of the round.
 * diceThrowValue(): counts the value of respective held dice.
 * displayResult(): binds together methods for calculating and setting result.
 * countDiceValues(): counts the total amount of each dice-value held.
 * 
 * @author Anton Wiklund
 *
 */

public class Yahtzee extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// Button to push in order to throw die's.
	private Button btn = new Button("Throw die");
	Text diceText = new Text("Round 1. Throws left: 3");
	
	// Images:
	private Image dice1 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/1.jpg"); private ImageView view1 = new ImageView(dice1);
	private Image dice2 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/2.jpg"); private ImageView view2 = new ImageView(dice2);
	private Image dice3 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/3.jpg"); private ImageView view3 = new ImageView(dice3);
	private Image dice4 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/4.jpg"); private ImageView view4 = new ImageView(dice4);
	private Image dice5 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/5.jpg"); private ImageView view5 = new ImageView(dice5);
	private Image dice6 = new Image("file:src/aw222zr_Assignment2/javaFX/DicePictures/6.jpg");
	
	// CheckBoxs:
	private CheckBox checkBtn1 = new CheckBox();
	private CheckBox checkBtn2 = new CheckBox();
	private CheckBox checkBtn3 = new CheckBox();
	private CheckBox checkBtn4 = new CheckBox();
	private CheckBox checkBtn5 = new CheckBox();
	
	// Start() sets the layout of the program.
	public void start(Stage stage) throws Exception {
		HBox checkButtons = new HBox();
		HBox diceImages = new HBox();
		HBox bottom = new HBox();
		GridPane grid = new GridPane();
				
		// Yahtzee label:
		Label yahtzee = new Label("Yahtzee");
		yahtzee.setFont(Font.font(40));
		yahtzee.setPadding(new Insets(0,0,0,10));
		
		// Add btn and diceText to bottom:
		bottom.getChildren().addAll(btn,diceText);
		bottom.setSpacing(10);
		bottom.setPadding(new Insets(0,0,10,10));
		bottom.setAlignment(Pos.CENTER_LEFT);
		
		// Set buttons to disabled:
		checkBtn1.setDisable(true);
		checkBtn2.setDisable(true);
		checkBtn3.setDisable(true);
		checkBtn4.setDisable(true);
		checkBtn5.setDisable(true);
		
		// Set buttons to CheckBoxs box:
		checkButtons.getChildren().addAll(checkBtn1,checkBtn2,checkBtn3,checkBtn4,checkBtn5);
		checkButtons.setPadding(new Insets(10,10,10,40));
		checkButtons.setSpacing(70);
		
		// Dice images:
		view1.setFitHeight(80);
		view1.setFitWidth(80);
		view2.setFitHeight(80);
		view2.setFitWidth(80);
		view3.setFitHeight(80);
		view3.setFitWidth(80);
		view4.setFitHeight(80);
		view4.setFitWidth(80);
		view5.setFitHeight(80);
		view5.setFitWidth(80);	
		diceImages.getChildren().addAll(view1,view2,view3,view4,view5);
		diceImages.setPadding(new Insets(0,10,0,10));
		diceImages.setSpacing(10);
		
		// Add to grid:
		grid.add(yahtzee, 0, 0);
		grid.add(diceImages, 0, 1);
		grid.add(checkButtons, 0, 2);
		grid.add(bottom, 0, 3);
		
		// Event-handler for the button.
		btn.setOnAction(e -> {
			if (round < 4) {
				playYahtzee();
			}
		});
		
		// Set scene and primary-stage:
		Scene scene = new Scene(grid, Color.WHITE);
		stage.setTitle("Yahtzee");
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Method which controls the check-boxes and sets the correct images to the 5 instances of ImageView.
	 * Also makes sure that correct values are set to the diceValueArray, which keeps track of the various dice's value's.
	 */
	private int[] diceValueArray = new int[5];
	private int round = 1;
	private void playYahtzee() {
		Random diceThrow = new Random();
		round++;
		
			if (round > 1) {
				checkBtn1.setDisable(false);
				checkBtn2.setDisable(false);
				checkBtn3.setDisable(false);
				checkBtn4.setDisable(false);
				checkBtn5.setDisable(false);
			}
				
			if (!checkBtn1.isSelected()) {
				int diceValue = diceThrow.nextInt(6) + 1;
				view1.setImage(diceThrowValue(diceValue));
				diceValueArray[0] = diceValue;
			}
			if (!checkBtn2.isSelected()) {
				int diceValue = diceThrow.nextInt(6) + 1;
				view2.setImage(diceThrowValue(diceValue));
				diceValueArray[1] = diceValue;
			}
			if (!checkBtn3.isSelected()) {
				int diceValue = diceThrow.nextInt(6) + 1;
				view3.setImage(diceThrowValue(diceValue));
				diceValueArray[2] = diceValue;
			}
			if (!checkBtn4.isSelected()) {
				int diceValue = diceThrow.nextInt(6) + 1;
				view4.setImage(diceThrowValue(diceValue));
				diceValueArray[3] = diceValue;
			}
			if (!checkBtn5.isSelected()) {
				int diceValue = diceThrow.nextInt(6) + 1;
				view5.setImage(diceThrowValue(diceValue));
				diceValueArray[4] = diceValue;
			}
			if (round >= 4) {
				displayResult(diceValueArray);
				round++;
				return;
			}
			diceText.setText("Round " + (round) + ". " + "Throws left: " + (4-round)); 
	}
	
	/**
	 * Counts the occurrences of different dice-values. If diceArray[0] == 1, then 1 is added to amountArray[0].
	 * if diceArray[0] == 6, then 1 is added to amountArray[5], and so on. 
	 * @param count
	 */
	private int[] amountArray = new int[6];
	private void countDiceValues(int diceArrayValue) {
		if (diceArrayValue == 1) {
			amountArray[0] += 1;
		} else if (diceArrayValue == 2) {
			amountArray[1] += 1;
		} else if (diceArrayValue == 3) {
			amountArray[2] += 1;
		} else if (diceArrayValue == 4) {
			amountArray[3] += 1;
		} else if (diceArrayValue == 5) {
			amountArray[4] += 1;
		} else if (diceArrayValue == 6) {
			amountArray[5] += 1;
		}
	}
	
	/**
	 * Method which starts, and finishes, the process of calculating and displaying the result(at the end of the round). 
	 * @param diceArray
	 */
	private void displayResult(int[] diceArray) {
		// Loop processes all the indexes in the array. diceArray[0] is representative of '1', diceArray[1] of '2', and so on. 
		for (int i = 0; i < diceArray.length; i++) {
			int countOccurences = diceArray[i];
			countDiceValues(countOccurences);
		}	
		countResult();
		resultText();
		return;
	}
	
	/**
	 * Checks which image that should be set for the ImageView instance which calls the method. 
	 * @param valueOfHeldDice
	 * @return image representing the dice-value in question.
	 */
	private Image diceThrowValue(int valueOfHeldDice) {
		if (valueOfHeldDice == 1) {
			return dice1;
		} else if (valueOfHeldDice == 2) {
			return dice2;
		} else if (valueOfHeldDice == 3) {
			return dice3;
		} else if (valueOfHeldDice == 4) {
			return dice4;
		} else if (valueOfHeldDice == 5) {
			return dice5;
		} else if (valueOfHeldDice == 6) {
			return dice6;
		}
		return null;
	}
	
	/**
	 * Counts the values in amountArray[int], to decide if has a straight, pair e.t.c. 
	 */
	private boolean yahtzeeResult = false;
	private boolean fourOf = false;
	private boolean threeOf = false;
	private boolean fullHouse = false;
	private boolean smallStraight = false;
	private boolean largeStraight = false;
	private boolean pair = false;
	private void countResult() {
		// Loop only checks if statements when it won't go out of bounds.
		for (int i = 0; i < amountArray.length; i++) {
			if (amountArray[i] >= 1 && i < 2) {
				if (amountArray[i+1] >= 1) {
					if (amountArray[i+2] >= 1) {
						if (amountArray[i+3] >= 1) { // Only return smallStraight if largeStraight == false.
							smallStraight = true;
							if (amountArray[i+4] >= 1) {
								largeStraight = true;
								return;
							}
							return;
						}
					}
				}
			}
		}
		
		// Loop checks for multiple values of same dice-value:
		for (int i = 0; i < amountArray.length; i++) {
			if (amountArray[i] == 5) {
				yahtzeeResult = true;
			} else if (amountArray[i] == 4) {
				fourOf = true;
			} else if (amountArray[i] == 3) {
				threeOf = true;
			} else if (amountArray[i] == 2) {
				pair = true;
			}
		}
		
		if (threeOf == true && pair == true) {
			fullHouse = true;
		}
	}
	
	/**
	 * Checks which final result that should be presented
	 */
	private void resultText() {
		if (yahtzeeResult == true) {
			diceText.setText("Final result: Yahtzee."); 
		} else if (fourOf == true) {
			diceText.setText("Final result: Four of a Kind.");
		} else if (fullHouse == true) {
			diceText.setText("Final result: Full House.");
		} else if (threeOf == true) {
			diceText.setText("Final result: Three of a Kind.");
		} else if (largeStraight == true) {
			diceText.setText("Final result: Large Straight.");
		} else if (smallStraight == true) {
			diceText.setText("Final result: Small Straight.");
		} else if (pair == true) {
			diceText.setText("Final result: Pair.");
		} else {
			diceText.setText("Final result: Null.");
		}
	}
}
