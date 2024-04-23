package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXSovellus extends Application {
	
	@Override
	public void start(Stage window) {
		BorderPane layout = new BorderPane();
		HBox hbox = new HBox();
		VBox vbox = new VBox();
		
		hbox.getChildren().add(new Label("First"));
		hbox.getChildren().add(new Label("Second"));
		hbox.getChildren().add(new Label("Third"));
		hbox.setSpacing(20);
		
		vbox.getChildren().add(new Label("Uno"));
		vbox.getChildren().add(new Label("Dos"));
		vbox.getChildren().add(new Label("Tres"));
		
		layout.setTop(new Label("Top"));
		layout.setRight(new Label("Right"));
		layout.setBottom(vbox);
		layout.setLeft(new Label("Left"));
		layout.setCenter(hbox);
		
		
		Scene view = new Scene(layout);
		
		window.setScene(view);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(JavaFXSovellus.class);
	}
}
