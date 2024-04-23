package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Notifier extends Application {
	
	public void start(Stage window) {
		TextField topText = new TextField();
		Button button = new Button("Update");
		Label label = new Label();
		
		topText.textProperty().addListener((change, oldValue, newValue) -> {
			System.out.println(oldValue + " -> " + newValue);
			label.setText(newValue);
		});
		
		button.setOnAction((event) -> {
			label.setText(topText.getText());
		});
		
		VBox box = new VBox();
		box.getChildren().setAll(topText, button, label);
		box.setSpacing(10);
		
		Scene scene = new Scene(box);
		
		window.setScene(scene);
		window.show();
	}
	
	
	public static void main(String[] args) {
		launch(Notifier.class);
	}
}
