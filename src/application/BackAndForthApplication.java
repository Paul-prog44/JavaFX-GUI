package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BackAndForthApplication extends Application {

  @Override
  public void start(Stage window) {

      Button back = new Button("Back ..");
      Button forth = new Button(".. forth.");

      Scene first = new Scene(back);
      Scene second = new Scene(forth);

      back.setOnAction((event) -> {
          window.setScene(second);
      });

      forth.setOnAction((event) -> {
          window.setScene(first);
      });

      window.setScene(first);
      window.show();
  }

  public static void main(String[] args) {
      launch(BackAndForthApplication.class);
  }
}