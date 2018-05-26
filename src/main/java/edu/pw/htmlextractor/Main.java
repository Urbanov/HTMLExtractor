package edu.pw.htmlextractor;

import edu.pw.htmlextractor.app.Controller;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Controller app = new Controller(primaryStage);
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
