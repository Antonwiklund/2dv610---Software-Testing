package aw222zr_Assignment2.javaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Class for, using javaFX, drawing a snowman.
 * Contains methods with the following functionality:
 * start() organizes the the various graphics.
 * main(String[] args) runs the graphics.
 * 
 * @author Anton Wiklund
 *
 */

public class Snowman extends Application {
	 
		public static void main(String[] args) {
	        launch(args);
	    }
	    
		/**
		 *  Method which, using javaFX, draws a snowman. 
		 * 
		 */
	    public void start(Stage primaryStage) {
	        
	    	// So we can group the elements together:
	    	Group root = new Group();
	    
	    	// The sun:
	    	Circle sun = new Circle(470, 105, 55, Color.ORANGERED);   	
	    	
	    	// The snowman:
	    	Circle snowmanLegs = new Circle(210, 280, 50, Color.WHITE);
	    	Circle snowmanTorso = new Circle(210, 220, 35, Color.WHITE);
	    	Circle snowmanHead = new Circle(210, 180, 20, Color.WHITE);
	    	Circle snowmanLeftEye = new Circle(205, 172, 4, Color.BLACK);
	    	Circle snowmanRightEye = new Circle(215, 172, 4, Color.BLACK);
	    	Circle snowmanButton1 = new Circle(210, 206, 3, Color.BLACK);
	    	Circle snowmanButton2 = new Circle(210, 216, 3, Color.BLACK);
	    	Circle snowmanButton3 = new Circle(210, 226, 3, Color.BLACK);
	    	Line snowmanMouth = new Line(200, 183, 220, 183);
	    	snowmanMouth.setStrokeWidth(3.5);
	    	Line snowmanLeftArm = new Line(180, 210, 160, 255);
	    	snowmanLeftArm.setStrokeWidth(4.8);
	    	Line snowmanRightArm = new Line(240, 210, 260, 255);
	    	snowmanRightArm.setStrokeWidth(4.8);
	    	Line snowmanHat1 = new Line(190, 160, 230, 160);
	    	snowmanHat1.setStrokeWidth(4.0);
	    	Rectangle snowmanHat2 = new Rectangle(200, 140, 20, 20);
	    	
	    	// The ground:
	    	Rectangle ground = new Rectangle(0, 300, 640, 480);
	    	ground.setStroke(Color.WHITE);
	    	ground.setFill(Color.WHITE);
	    	
	    	// Group all elements together:
	    	root.getChildren().addAll( snowmanLegs, snowmanTorso, snowmanLeftArm, snowmanRightArm, snowmanHead, snowmanMouth, 
	    	snowmanRightEye, snowmanButton1, snowmanButton2, snowmanHat1, snowmanHat2, snowmanButton3, snowmanLeftEye, ground, sun);
	    	
	    	// Add elements to scene:
	    	Scene scene = new Scene(root, 640, 480, Color.LIGHTBLUE);
	    	
	    	// Setup the scene, and show it:
	    	primaryStage.setTitle("Melancholy snowman"); 
	    	primaryStage.setScene(scene); 
	    	primaryStage.show();
	    }
}
