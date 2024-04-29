package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PracticeView {
	private Dictionary dictionary;
	private String word;
	
	public PracticeView(Dictionary dictionary) {
		this.dictionary = dictionary;
		this.word = dictionary.getRandom();
	}
	
	public Parent getView() {
		GridPane layout = new GridPane();
		
		Label wordInstruction = new Label("Translate the word '" + this.word + "'");
		TextField translationField = new TextField();
		
		layout.setAlignment(Pos.CENTER);
		layout.setVgap(10);
		layout.setHgap(10);
		layout.setPadding(new Insets(10, 10, 10, 10));
		
		Button addButton = new Button("Check");
		
		Label feedback = new Label("");
		
		layout.add(wordInstruction, 0, 0);
		layout.add(translationField, 0, 1);
		layout.add(addButton, 0, 2);
		layout.add(feedback, 0, 3);
		
		addButton.setOnMouseClicked((event) -> {
			String translation = translationField.getText();
			if (dictionary.get(this.word).equals(translation)) {
				feedback.setText("Correct!");
			} else {
				feedback.setText("Incorrect ! The translation for the word " + this.word + " is " + dictionary.get(this.word));
				return;
			}
			
			this.word = this.dictionary.getRandom();
			wordInstruction.setText("Translate the word '" + this.word + "'");
			translationField.clear();
		});
		
		return layout;
	}
}