package MultimediaPrograms;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MultimediaImage extends Application {
	
	@Override
	public void start(Stage stage) {

		Image imageFile = new Image("file:C:\\Users\\Gérald\\eclipse-workspace\\JavaFXMOOC\\humming.jpg");
		ImageView image = new ImageView(imageFile);

	    image.setScaleX(0.5);
	    image.setScaleY(0.5);

	    image.setTranslateX(50);

	    Pane frame = new Pane();
	    frame.getChildren().add(image);

	    stage.setScene(new Scene(frame));
	    stage.show();
	}
	
	public static void main(String[] args) {
		launch(MultimediaImage.class);
	}
}
