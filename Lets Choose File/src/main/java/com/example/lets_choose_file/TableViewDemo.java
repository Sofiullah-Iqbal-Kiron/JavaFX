package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new FXMLLoader(getClass().getResource("table_view.fxml")).load();
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
