package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.concurrent.Flow;

public class ComboBoxTraining extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        FlowPane root = new FlowPane();
        Scene scene = new Scene(root);

        ObservableList<String> items = FXCollections.observableArrayList("Item 1", "Item 2", "Item 3");
        ComboBox<String> box = new ComboBox<>(items);
        box.getSelectionModel().select(0);

        root.getChildren().add(box);

//        Setting stage, the main top level container.
        stage.setScene(scene);
        setStage(stage);
    }

    private void setStage(Stage stage) {
        stage.setTitle("ComboBox Training");

        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }
}