package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.DECORATED);

        HBox hBox = new HBox();
        Scene scene = new Scene(hBox, 200, 400);

        ButtonType login = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        Dialog<String> dialog = new Dialog();
        dialog.setTitle("DialogDemo: Login");
        dialog.setContentText("Would you like to login? ");
        dialog.getDialogPane().getButtonTypes().add(login);

        TextInputDialog td = new TextInputDialog();
        td.setTitle("Text Input Dialog Title");
        td.setHeaderText("Text Input");

        Button showDialog = new Button("Show Dialog");
        showDialog.setOnAction(e -> td.showAndWait());

        hBox.getChildren().add(showDialog);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
