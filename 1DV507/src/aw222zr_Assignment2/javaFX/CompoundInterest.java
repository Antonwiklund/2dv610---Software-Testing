package aw222zr_Assignment2.javaFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Class which calculates compound interest.
 * Contains methods with the following functionality:
 * main(): launches the program.
 * start(): creates the program.
 * handle(): adds an event-handler to the button.
 * testTextField(): tests TextField-string so that it only has numeric and '.' values. 
 * 
 * @author Anton Wiklund
 *
 */

public class CompoundInterest extends Application {

	// Launcher:
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 *  Creates the program.
	 *  
	 */
	// Text for the result of sum after added compound interest.
	Text resultText = new Text();
	public void start(Stage primaryStage) {
		// GridPane and Group for organizing nodes:
		GridPane grid = new GridPane();
		Group root = new Group();
		
		// Label:
		Label programName = new Label("Compound Interest: ");
		programName.setFont(Font.font(null, FontWeight.BOLD, 24));
		programName.setPadding(new Insets(0,0,0,10));
		
		// Various Text and TextFields.
		Text startAmount = new Text("Start amount: ");
		Text interest = new Text("Interest: ");
		Text numberOfYears = new Text("Number of years: ");
		final TextField startAmountField = new TextField();
		final TextField interestField = new TextField();
		final TextField numberOfYearsField = new TextField();
		startAmountField.setMaxWidth(115);
		interestField.setMaxWidth(115);
		numberOfYearsField.setMaxWidth(115);
		
		// Button to click for receiving sum.
		Button btn = new Button("Calculate: ");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
		// Event-handler which handles the user pressing 'btn'.
		public void handle(ActionEvent arg0) {
			// Checks so that input to fields consist of numbers:
			String testStart = startAmountField.getText();
			String testYears = numberOfYearsField.getText();
			String testInterest = interestField.getText();

			// testTextField checks so that input to respective TextField is numeric:
			if (testTextField(testStart) == false) {
				return;
			};
			if (testTextField(testYears) == false) {
				return;
			};
			if (testTextField(testInterest) == false) {
				return;
			};
			
			// Checks whether all fields have input in them:
			if ( startAmountField.getText().isEmpty() == true || numberOfYearsField.getText().isEmpty() == true || interestField.getText().isEmpty() == true) {
				resultText.setText("Input values.");
				resultText.setVisible(true);
				return;
			}
			Double startDouble = Double.parseDouble(startAmountField.getText());
			Double interestDouble = Double.parseDouble(interestField.getText());
			Double yearsDouble = Double.parseDouble(numberOfYearsField.getText());
			Double sum = startDouble;
			Double interestRecalc = (1+(interestDouble/100));
			// Loop calculates yearly interest to be added to sum.
			for (double i = 0; i < yearsDouble; i++) {
				sum *= interestRecalc; 
			}
			
			String sumOut = Double.toString(Math.round(sum));
			resultText.setText(sumOut);
			resultText.setVisible(true);
			return;
		}});
		
		// Add all nodes to grid.
		grid.add(startAmount, 0, 1);
		grid.add(startAmountField, 1, 1);
		grid.add(interest, 0,2);
		grid.add(interestField, 1, 2);
		grid.add(numberOfYears, 0, 3);
		grid.add(numberOfYearsField, 1, 3);
		grid.add(btn, 0, 4);
		grid.add(resultText, 0, 5, 2, 1);
		grid.setAlignment(Pos.CENTER_LEFT);
		grid.setHgap(10);
		grid.setVgap(5);
		grid.setPadding(new Insets(30,0,10,10));

		// Add name of program to group, add grid to group.
		root.getChildren().addAll(programName, grid);
		
		// New scene.
		Scene scene = new Scene(root, 280, 180, Color.LIGHTGREY);
		
		// Set scene. Initialize primaryStage.
		primaryStage.setTitle("Compound Interest:");
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	/**
	 * Method tests strings for numeric and '.' characters.
	 * @param testString
	 * @return
	 */
	private boolean testTextField(String testString) {
		for (int i = 0; i < testString.length(); i++) {
			Character testForNum = testString.charAt(i);
			if (Character.isDigit(testForNum) || testForNum == '.') {
			} else {
				resultText.setText("Only numbers and '.' allowed.");
				return false;
			}
		}
		return true;
	}
}
