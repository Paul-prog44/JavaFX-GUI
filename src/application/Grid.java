package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Grid extends Application {
	
	public void start(Stage window) {
		GridPane layout = new GridPane();
		
	    for (int x = 1; x <= 3; x++) {
	        for (int y = 1; y <= 3; y++) {
	            layout.add(new Button("" + x + ", " + y), x, y);
	        }
	    }
	    window.setTitle("Grid");
	    Scene view = new Scene(layout);
	    window.setScene(view);
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(Grid.class);
	}
}
