package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Greeter extends Application {
	
	@Override
	public void start(Stage window) {
		Label instruction = new Label("Enter your name and start.");
		TextField username = new TextField();
		Button startButton = new Button("Start");
		
		GridPane layout = new GridPane();
		layout.add(instruction, 0, 0);
		layout.add(username, 0, 1);
		layout.add(startButton, 0, 2);
		
		layout.setPrefSize(300, 180);
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(20, 20, 20, 20));
		
		Scene UsernameView = new Scene(layout);
		
		
		StackPane welcomeView = new StackPane();
		welcomeView.setPrefSize(300, 180);
		welcomeView.setAlignment(Pos.CENTER);
		
		Scene welcomePage = new Scene(welcomeView);
		
		
		startButton.setOnAction((event)-> {
			Label welcomeText = new Label("Bienvenu " + username.getText() + " !");
			welcomeView.getChildren().add(welcomeText);

			window.setScene(welcomePage);
		});
		
		window.setScene(UsernameView);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(Greeter.class);
	}
}
