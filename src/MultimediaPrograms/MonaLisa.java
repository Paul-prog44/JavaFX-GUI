package MultimediaPrograms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MonaLisa extends Application {
	@Override 
	public void start(Stage stage) {
		Image imageFile = new Image("file:C:/Users/Gérald/eclipse-workspace/JavaFXMOOC/monaLisa.jpg");
		
		PixelReader pixels = imageFile.getPixelReader();
		int width = (int) imageFile.getWidth();
		int height = (int) imageFile.getHeight();
		
		WritableImage targetImage = new WritableImage(width, height);
		PixelWriter writer = targetImage.getPixelWriter();
		
		for (int y=0; y<height; y++) {
			for (int x=0; x<width;x++) {
				Color pixelColor = pixels.getColor(x, y);
	            double red = 1.0-pixelColor.getRed();
	            double green = 1.0-pixelColor.getGreen();
	            double blue = 1.0-pixelColor.getBlue();
	            double opacity = pixelColor.getOpacity();

	            Color newColor = new Color(red, green, blue, opacity);

	            writer.setColor(x/2, y/2, newColor);
	            writer.setColor(x/2+width/2, y/2, newColor);
	            writer.setColor(x/2+width/2, y/2+height/2, newColor);
	            writer.setColor(x/2, y/2+height/2, newColor);


			}
		}
		
		ImageView image = new ImageView(targetImage);
		
		Pane pane = new Pane();
		pane.getChildren().add(image);
		
		stage.setScene(new Scene(pane));
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(MonaLisa.class);
	}
}
