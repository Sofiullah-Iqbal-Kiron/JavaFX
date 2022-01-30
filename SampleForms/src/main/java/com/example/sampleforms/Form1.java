// My hands on implementation of this example: https://docs.oracle.com/javase/8/javafx/get-started-tutorial/form.htm

// Set background for gridPane which I used here.

/*
 * Topics:
 * 1. GridPane: https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/layout/GridPane.html
 * 2. Insets.
 * 3. Enum Pos: https://openjfx.io/javadoc/17/javafx.graphics/javafx/geometry/Pos.html
 * 4. Background: https://openjfx.io/javadoc/17/javafx.graphics/javafx/scene/layout/Background.html#getFills()
 * Utility tutorial for Background: http://tutorials.jenkov.com/javafx/region.html#:~:text=image%20as%20background.-,Set%20Background%20Color,new%20Background(backgroundFill)%3B%20pane.
 * 5. HBox.
 */

/* GridPane:
 * Grid style layout container.
 * Extends javafx.scene.layout.Pane
 * Lays out its children within a flexible grid of rows and columns.
 * We should enable display gridlines which is useful for debugging purposes: gridPane.setGridLinesVisible(true);
 */

package com.example.sampleforms;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form1 extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //        Constructs a new gridPane, a panel(container) with grid layout.
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //        grid.setGridLinesVisible(true);

        //        Welcome text.
        Text sceneTitle = new Text("Welcome!");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        //        Username.
        Label userName = new Label("Username: ");
        TextField userTextField = new TextField();
        grid.add(userName, 0, 1);
        grid.add(userTextField, 1, 1);

        //        Password.
        Label password = new Label("Password: ");
        PasswordField passwordField = new PasswordField();
        grid.add(password, 0, 2);
        grid.add(passwordField, 1, 2);

        //        Button.
        Button signIn = new Button("Sign-IN");
        HBox signInHolder = new HBox(10);
        signInHolder.setAlignment(Pos.BOTTOM_RIGHT);
        signInHolder.getChildren().add(signIn);
        grid.add(signInHolder, 1, 4);

        //        ActionTarget text.
        Text actionTarget = new Text("");
        grid.add(actionTarget, 1, 6);

        Scene scene = new Scene(grid, 300, 275);

        //        Register an action to the button.
        signIn.setOnAction(e -> {
            String curTxt = actionTarget.getText();
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText(String.valueOf("Stage width: " + stage.getWidth() + "\nStage height: " + stage.getHeight()));
        });

        stage.setScene(scene);
        stage.setTitle("JavaFX Welcome!");
        stage.setMinHeight(300.0); // Minimum pixel of height no matter how much we shrink the stage.
        stage.setMinWidth(300.0); // Minimum pixel of width no matter how much we shrink the stage width.
        stage.show();
        stage.sizeToScene();
    }
}
