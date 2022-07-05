package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class IconicButton extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10.0);
        Scene scene = new Scene(root, 260, 300);

        root.getChildren().add(new AddObjectPanel());
        root.getChildren().add(new TimeLinePanel());

        ObservableList<String> options = FXCollections.observableArrayList("Foo", "Bar", "Baz");
        ComboBox comboBox = new ComboBox(options);
        comboBox.getItems().add("Too");
        comboBox.setValue("Bar");
        root.getChildren().add(comboBox);

        ButtonType login = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        Dialog<String> dialog = new Dialog();
        dialog.setTitle("DialogDemo: Login");
        dialog.setContentText("Would you like to login? ");
        dialog.getDialogPane().getButtonTypes().add(login);
        dialog.initOwner(stage);

        Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(e -> {
            dialog.showAndWait();
        });

        root.getChildren().add(showDialog);

        stage.setTitle("Iconic Button");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.sizeToScene();
        stage.show();
    }
}
