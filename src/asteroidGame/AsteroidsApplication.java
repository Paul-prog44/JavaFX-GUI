package asteroidGame;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class AsteroidsApplication extends Application {
	
	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		pane.setPrefSize(600, 400);
		
		Ship ship = new Ship(150, 100);
		
		pane.getChildren().add(ship.getCharacter());
		
		Scene scene = new Scene(pane);
		
		Map<KeyCode, Boolean> pressedKeys = new HashMap<>();
		
		scene.setOnKeyPressed(event -> {
			pressedKeys.put(event.getCode(), Boolean.TRUE);
		});
		
		scene.setOnKeyReleased(event -> {
			pressedKeys.put(event.getCode(), Boolean.FALSE);
		});
		
		Point2D movement = new Point2D(1, 0);
		
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
					ship.turnLeft();
				}
				
				if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
					ship.turnRight();
				}
				
				if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
					ship.accelerate();
				}
				
				ship.move();
			}
		}.start();
		
		stage.setTitle("Asteroids !");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}