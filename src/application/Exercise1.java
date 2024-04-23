package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise1 extends Application {
	
	@Override
	public void start(Stage window) {
		BorderPane layout = new BorderPane();
		HBox hbox = new HBox();
		TextArea textfield = new TextArea();
		
		hbox.getChildren().add(new Label("Letters: 0"));
		hbox.getChildren().add(new Label("Words: 0"));
		hbox.getChildren().add(new Label("The longest word is:"));

				
		layout.setCenter(textfield);
		layout.setBottom(hbox);
		
		Scene view = new Scene(layout);
		
		window.setScene(view);
		window.show();
	}
	
	
	public static void main(String[] args) {
		launch(Exercise1.class);
	}
}
