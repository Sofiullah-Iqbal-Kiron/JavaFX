package com.example.layingout;

/*
 * FlowPane layout allows child nodes in a nodes to flow based on the available horizontal spacing.
 * And then wrap nodes to the next line when horizontal space is less than the total of all the node's width.
 * Default flows, left to right and Pos.TOP_LEFT
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlowPane_Training extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(new Text("Hello 1"), new Text("Hello 2"), new Text("Hello 3"));

        Scene scene = new Scene(pane);
        stage.setTitle("Layout: HBox");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
