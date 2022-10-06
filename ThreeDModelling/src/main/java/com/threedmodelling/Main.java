package com.threedmodelling;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static final double Width = 600, Height = 320;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));

        Group group = new Group();
        Scene scene = new Scene(group, Width, Height);
        Shape sphere = new Circle(100, Color.GREEN);
        sphere.translateXProperty().set(Width / 2);
        sphere.translateYProperty().set(Height / 2);

        HBox bottom = new HBox();
        bottom.setSpacing(20);
        Button up = new Button("UP"), down = new Button("Down");
        bottom.getChildren().addAll(up, down);

        group.getChildren().addAll(sphere, bottom);

        up.setOnAction(e -> sphere.translateZProperty().set(sphere.getTranslateZ() + 100));
        down.setOnAction(e -> sphere.translateZProperty().set(sphere.getTranslateZ() - 100));

        scene.setCamera(new PerspectiveCamera());
        stage.setTitle("3D Modelling!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}