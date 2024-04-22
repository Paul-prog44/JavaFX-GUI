package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;


public class Main extends Application {
	
	
	@Override
    public void start(Stage window) {
		Label textComponent = new Label("Text element");
		Button buttonComponent = new Button("This is a button");
		RadioButton rb1 = new RadioButton("Hello");
		TextField text = new TextField("New text");
		rb1.setText("Hello");
		
		FlowPane componentGroup = new FlowPane();
		componentGroup.getChildren().add(textComponent);
		componentGroup.getChildren().add(buttonComponent);
		componentGroup.getChildren().add(rb1);
		componentGroup.getChildren().add(text);

		
		Scene view = new Scene(componentGroup);
		window.setTitle("Hello World!");
		window.setScene(view);
		window.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
