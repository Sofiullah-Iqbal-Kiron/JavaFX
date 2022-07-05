package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");

        Button openFileChooser = new Button("Select a file...");
        Button saveFileChooser = new Button("Save the file.");

        openFileChooser.setOnAction(e -> {
            try {
                File selectedFile = fileChooser.showOpenDialog(stage);
                System.out.println(selectedFile.toString());
            } catch(Exception ex) {
                System.out.println("No file selected.");
            }
        });

        saveFileChooser.setOnAction(e -> {
            File savedFile = fileChooser.showSaveDialog(stage);
            System.out.println("Saved file: " + savedFile);
        });

        VBox root = new VBox();

        HBox buttonHolder = new HBox();
        buttonHolder.setPadding(new Insets(2));
        buttonHolder.setAlignment(Pos.CENTER);
        buttonHolder.setSpacing(20.0);
        buttonHolder.getChildren().addAll(openFileChooser, saveFileChooser);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(buttonHolder, fxmlLoader.load());

        Scene scene = new Scene(root);

        stage.setTitle("File Chooser Demo");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}