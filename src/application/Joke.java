package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Joke extends Application{
	public void start(Stage window) {
		
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        
        menu.getChildren().addAll(joke, answer, explanation);
        layout.setTop(menu);
        
        StackPane jokePanel = createView("What do you call a bear with no teeth?");
        StackPane answerPanel = createView("A gummy bear");
        StackPane jokeExplanation = createView("A gummy bear is not a rel bear, ..obvisouly!");
        
        joke.setOnAction((event) -> layout.setCenter(jokePanel));
        answer.setOnAction((event) -> layout.setCenter(answerPanel));
        explanation.setOnAction((event) -> layout.setCenter(jokeExplanation));
        
        layout.setCenter(jokePanel);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
		
	}
	
	//Methode pour créer une StackPane
	private StackPane createView(String text) {
		StackPane layout = new StackPane();
		layout.setPrefSize(300, 180);
		layout.getChildren().add(new Label(text));
		layout.setAlignment(Pos.CENTER);
		
		return layout;
	}
	
	public static void main(String[] args) {
		launch(Joke.class);
	}

}


