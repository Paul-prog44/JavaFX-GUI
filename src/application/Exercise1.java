package application;


import java.util.Arrays;

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
		
		Label labelWords = new Label();
		Label numberOfCharacters = new Label();
		Label longestWord = new Label();
		numberOfCharacters.setText("Characters: ");
		labelWords.setText("Words: ");
		longestWord.setText("The longest word is: ");
		
		textfield.textProperty()
			.addListener((change, oldValue, newValue) -> {
				int characters = newValue.length();
				String[] parts = newValue.split(" ");
				int words = parts.length;
				String longest = Arrays.stream(parts)
						.sorted((s1, s2) -> s2.length() - s1.length())
						.findFirst()
						.get();
				
				numberOfCharacters.setText("Characters: "+ characters);
				labelWords.setText("Words: "+ words);
				longestWord.setText("The longest word is: " + longest);
				
			});
		
		hbox.setSpacing(10);
		
		hbox.getChildren().add(numberOfCharacters);
		hbox.getChildren().add(labelWords);
		hbox.getChildren().add(longestWord);

				
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
