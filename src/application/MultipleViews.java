package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
	@Override
	public void start(Stage window) {
		BorderPane box1 = new BorderPane();
		Button firstButton = new Button("To the second view");
		Button secondButton = new Button("To the third view");
		Button thirdButton = new Button("To the first view");
		Label thirdLabel = new Label("Third view");
		
		
		VBox box2 = new VBox(secondButton, new Label("Second view!"));
		
		GridPane box3 = new GridPane();
		box3.setConstraints(thirdLabel, 0, 0);
		box3.setConstraints(thirdButton, 1, 1);
		box3.getChildren().addAll(thirdLabel, thirdButton);
		
		Scene firstScene = new Scene(box1);
		Scene secondScene = new Scene(box2);
		Scene thirdScene = new Scene(box3);
		
		firstButton.setOnAction((event) -> {
			window.setScene(secondScene);
		});
		
		secondButton.setOnAction((event) ->{
			window.setScene(thirdScene);
		});
		
		thirdButton.setOnAction((event) -> {
			window.setScene(firstScene);
		});
		
		box1.setTop(new Label("First view"));
		box1.setCenter(firstButton);
		
		window.setScene(firstScene);
		window.show();
	}
	
	public static void main(String[] args) {
		launch(MultipleViews.class);
	}
}
