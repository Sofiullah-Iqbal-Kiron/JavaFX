package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new VBox());

        stage.setTitle("Text Area Demonstration");
        stage.setScene(scene);
        stage.setAlwaysOnTop(false);
        stage.sizeToScene();
        stage.show();
    }
}
