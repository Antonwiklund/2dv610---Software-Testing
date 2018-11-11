package aw222zr_assignment3.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TinyPainter extends Application {

	public static void main(String[] args) throws Exception {
		launch(args);		
	}

	String currentShape = "start";
	Circle thisCircle = null;
	double startPathX = 0;
	double startPathY = 0;
	double traversePathX = 0;
	double traversePathY = 0;
	Circle newCircle = null;
	
	/**
	 * Creates a very basic painting program.
	 */
	public void start(Stage primaryStage){
		
		// Canvas and GraphicsContext settings:
		Canvas canvas = new Canvas(600, 600);
		GraphicsContext canvasGraphics; 
		canvasGraphics = canvas.getGraphicsContext2D();
		canvasGraphics.setLineWidth(1.0);
		canvasGraphics.setStroke(Color.RED);
		canvasGraphics.setFill(Color.RED);
		
		// Color Menu:
		ColorPicker colorPick = new ColorPicker();
		colorPick.setValue(Color.RED);
		colorPick.setOnAction(e -> {
			canvasGraphics.setStroke(colorPick.getValue());
			canvasGraphics.setFill(colorPick.getValue());
		});
		
		// Size Menu:
		Slider sizeSlider = new Slider();
		sizeSlider.setMin(1);
		sizeSlider.setMax(40);
		sizeSlider.setShowTickLabels(true);
		sizeSlider.setShowTickMarks(true);
		sizeSlider.setMinorTickCount(5);
		sizeSlider.setMajorTickUnit(20);
		MenuItem thickness = new MenuItem(null, sizeSlider);
			
		// Menu bar:
		MenuBar mainMenu = new MenuBar();
		Menu shapeMenu = new Menu("Shape");
		Menu colorMenu = new Menu(null, colorPick);
		Menu menuMenu = new Menu("Menu");
		Menu sizeMenu = new Menu("Current thickness: 1.0");
		sizeMenu.getItems().add(thickness);
		mainMenu.getMenus().addAll(menuMenu, shapeMenu, sizeMenu, colorMenu);
		mainMenu.setMinHeight(32);		
		mainMenu.isVisible();
		
		// Shape Menu:
		MenuItem line = new MenuItem("Line");
		MenuItem circle = new MenuItem("Circle");
		MenuItem rectangle = new MenuItem("Rectangle");
		MenuItem dot = new MenuItem("Dot");
		shapeMenu.getItems().addAll(line, circle, rectangle, dot);
		
		// Menu Menu:
		MenuItem exitProgram = new MenuItem("Exit");
		MenuItem clearCanvas = new MenuItem("Clear Canvas");
		menuMenu.getItems().addAll(clearCanvas, exitProgram);
		exitProgram.setOnAction(e -> {
			System.exit(10);
		});
		
		// VBox and GridPane:
		VBox vBox = new VBox();
		vBox.getChildren().addAll(mainMenu, canvas);
		GridPane gridPane = new GridPane();
		gridPane.getChildren().addAll(vBox);
		
		// Setup 'scene', EventHandlers, and 'primaryStage':
		Scene scene = new Scene(gridPane, 600, 600);
		
		line.setOnAction(e -> {
			currentShape = "line";
		});
		
		rectangle.setOnAction(e -> {
			currentShape = "rectangle";
		});
		
		circle.setOnAction(e -> {
			currentShape = "circle";
		});
		
		dot.setOnAction(e -> {
			currentShape = "dot";
		});
		
		clearCanvas.setOnAction(e -> {
			canvasGraphics.clearRect(0,0, 600, 600);
		});
		
		scene.setOnMousePressed(e -> {
			if (currentShape == "line" || currentShape == "start") {
				canvasGraphics.beginPath();
				canvasGraphics.strokeLine(e.getSceneX(), e.getSceneY()-36, e.getSceneX(), e.getSceneY()-36);
				canvasGraphics.stroke();
			} else if(currentShape == "rectangle") {
				startPathX = e.getX();
				startPathY = e.getY()-42;
			} else if(currentShape == "circle") {
				startPathX = e.getX();
				startPathY = e.getY()-42;
				newCircle = new Circle(startPathX, startPathY+4, traversePathX);
			}
		});
		
		scene.setOnMouseClicked(e -> {
			if(currentShape == "dot") {
				canvasGraphics.setFill(colorPick.getValue());
				canvasGraphics.fillOval(e.getX()-3, e.getY()-40, sizeSlider.getValue(), sizeSlider.getValue());
			}
		});
		
		scene.setOnMouseDragged(e -> {
			if (currentShape == "line" || currentShape == "start") {
				canvasGraphics.lineTo(e.getSceneX(), e.getSceneY()-36);
				canvasGraphics.stroke();
			} else if(currentShape == "rectangle") {
				traversePathX = (startPathX - e.getX());
				if (traversePathX < 0) {
					traversePathX = -traversePathX;
				}
				traversePathY = (startPathY - e.getY());
				if (traversePathY < 0) {
					traversePathY = -traversePathY;
				}		
				canvasGraphics.fillRect(startPathX, startPathY+4, traversePathX, traversePathY-40);
			} else if(currentShape == "circle") { 
				traversePathX = (startPathX - e.getX());
				if (traversePathX < 0) {
					traversePathX = -traversePathX;	
				}				
				// BUG: If move the circle too fast, circle becomes uneven. Haven't been able to come up with a solution.
				// Do you know somewhere I can read, so I can write a better solution?
				canvasGraphics.strokeOval(startPathX, startPathY+4, traversePathX, traversePathX);
				if ((startPathX - e.getX()) <= 0) {
					startPathY -= 1;
					startPathX -= 1;
				} else if ((startPathX - e.getX()) > 0) {
					startPathY -= 0.5;
					startPathX -= 0.5;
				}
			}
		});
		
		scene.setOnMouseReleased(e -> {
			startPathX = 0;
			startPathY = 0;
			traversePathX = 0;
			traversePathY = 0;
		});
		
		sizeSlider.valueProperty().addListener(e -> {
			Double sliderValue = sizeSlider.getValue();
			String sliderString = String.format("%.1f", sliderValue);
			sizeMenu.setText("Current thickness: " + sliderString);
			canvasGraphics.setLineWidth(sliderValue);
		});
		
		primaryStage.setTitle("Tiny Painter");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
