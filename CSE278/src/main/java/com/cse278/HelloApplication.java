package com.cse278;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static double mainStageCurrentHeight = 0.0;

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = new FXMLLoader(getClass().getResource("Main.fxml")).load();
        Scene scene = new Scene(root);

//        Setting stage, the main top level container.
        stage.setScene(scene);
        setStage(stage);
    }

    private void setStage(Stage stage) {
        stage.setTitle("Halogen Transport Agency");

        Image stageIcon = new Image(String.valueOf(getClass().getResource("Icon.jpg")));
        stage.getIcons().add(stageIcon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}