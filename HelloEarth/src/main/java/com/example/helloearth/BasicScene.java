package com.example.helloearth;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class BasicScene extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 200, 300, Color.BLACK);

        Rectangle r = new Rectangle(0, 0, 90, 90);
        r.setArcHeight(1.1);
        r.setArcWidth(1.1);
        r.setFill(Color.WHITE);
        root.getChildren().add(r);
        Rectangle r2 = new Rectangle(0, 0, 30, 30);
        r2.setFill(Color.RED);
        Group g1 = new Group();
        g1.getChildren().add(r2);
        root.getChildren().add(g1);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
}