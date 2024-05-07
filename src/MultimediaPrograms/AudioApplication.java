package MultimediaPrograms;

import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;


public class AudioApplication extends Application {

    @Override
    public void start(Stage stage) {

        AudioClip sound = new AudioClip("file:C:/Users/Gérald/Downloads/front-desk-bells-daniel_simon.wav");
        sound.play();

        stage.show();
    }

    public static void main(String[] args) {
        launch(AudioApplication.class);
    }

}
