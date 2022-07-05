package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GroupDemo extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group group = new Group();

        for(int i = 0; i < 5; i++) {
            Rectangle r = new Rectangle();
            r.setY(20);
            r.setWidth(100);
            r.setHeight(10);
            r.setFill(Color.RED);
            group.getChildren().add(r);
        }

        Scene scene = new Scene(group);

        stage.setTitle("Group Demo");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.sizeToScene();
        stage.show();
    }
}
