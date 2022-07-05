package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UpdationChecking extends Application {
    private static int c = 1;

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        TimeLinePanel p = new TimeLinePanel();
        Button B = new Button("Click");
        root.getChildren().addAll(p, B, new Button("Two"));
        B.setOnAction(e -> p.getChildren().add(new Button("Added" + (c++))));

        Scene scene = new Scene(root);

        stage.setTitle("Iconic Button");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.sizeToScene();
        stage.show();
    }
}
