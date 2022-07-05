/*
 * ToggleGroup do not attempt to force the selection at least one button in the group.
 */

package com.example.lets_choose_file;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ToggleDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        VBox root = new VBox();

        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton minor = new ToggleButton("Minor");
        ToggleButton major = new ToggleButton("Major");
        ToggleButton critical = new ToggleButton("Critical");
        minor.setToggleGroup(toggleGroup);
        major.setToggleGroup(toggleGroup);
        critical.setToggleGroup(toggleGroup);

        minor.setUserData(Color.LIGHTGREEN);
        major.setUserData(Color.LIGHTBLUE);
        critical.setUserData(Color.SALMON);

        Rectangle r = new Rectangle(145, 50);

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle new_toggle) {
                if(new_toggle == null) r.setFill(Color.WHITE);
                else r.setFill((Color) toggleGroup.getSelectedToggle().getUserData());
            }
        });

        minor.setStyle("-fx-base: lightgreen;");
        major.setStyle("-fx-base: lightblue;");
        critical.setStyle("-fx-base: salmon;");

        Scene scene = new Scene(root);
        HBox b = new HBox();
        b.getChildren().addAll(minor, major, critical);
        root.getChildren().addAll(b, r);

        stage.setTitle("Iconic Button");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.sizeToScene();
        stage.show();
    }
}
