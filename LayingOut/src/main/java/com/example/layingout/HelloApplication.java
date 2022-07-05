package com.example.layingout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        */

        Group root = new Group();
        Scene scene = new Scene(root, 300, 250);

        HBox hBox = new HBox(5); // Specified spacing between children in pixel.

        // BorderStroke, stroke is a vector based rendering that outlines the border area.
        BorderStroke[] borderStrokes = new BorderStroke[]{new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(0.0, true), BorderStroke.THICK)};
        hBox.setBorder(new Border(borderStrokes));

        hBox.setPadding(new Insets(1));

        // Rectangles through r1 to r4.
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 20);
        Rectangle r3 = new Rectangle(5, 20);
        Rectangle r4 = new Rectangle(20, 5);

        HBox.setMargin(r1, new Insets(2, 2, 2, 2));
        // Set and Assign border for r1.
        BorderStroke[] borderStrokesFor_r1 = new BorderStroke[]{new BorderStroke(Color.FORESTGREEN, BorderStrokeStyle.DOTTED, new CornerRadii(0.0, true), BorderStroke.THICK)};

        hBox.getChildren().addAll(r1, r2, r3, r4);
        root.getChildren().add(hBox);

        stage.setTitle("Layout: HBox");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}