package TicTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserInterface extends Application{
	
	@Override 
	public void start(Stage window) {
		BorderPane layout = new BorderPane();
		HBox hbox = new HBox();
		Label turn = new Label("Turn : ");
		Label player = new Label("X");
		Label endMessage = new Label("Player X has won, congratulations !");
				
		
		turn.setFont(new Font(20));
		player.setFont(new Font(20));
		endMessage.setFont(new Font(12));
		
		hbox.getChildren().add(turn);
		hbox.getChildren().add(player);
	

		GridPane grid = new GridPane();
		
		
		for (int x = 1; x <= 3; x++) {
	        for (int y = 1; y <= 3; y++) {
	        	Button btn = new Button();
	        	btn.setFont(Font.font("Monospaced", 40));
	        	btn.setOnAction((event) -> {
	        		if (player.getText().equals("X")) {
	        			btn.setText(player.getText());
	        			player.setText("O");
	        			
	        		} else {
	        			btn.setText(player.getText());
	        			player.setText("X");
	        		}
	        	});
	        	
	        	grid.add(btn, x, y);
	        	grid.setMargin(btn, new Insets(5));
	        }
	    }
		
	
		
		 

		layout.setTop(hbox);
		layout.setCenter(grid);
		layout.setBottom(endMessage);

		layout.setPadding(new Insets(40));
		Scene view = new Scene(layout, 400, 400);
		
		window.setTitle("Tic-Tac-Toe");
		window.setScene(view);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(UserInterface.class);
	}
}
