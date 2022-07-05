// Issue: https://stackoverflow.com/questions/53147549/source-not-found-importing-css-to-javafx

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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Form_with_css extends Application {
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
        sceneTitle.setId("welcome-text");
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
        actionTarget.setId("actionTarget");
        grid.add(actionTarget, 1, 6);

        //        Creating scene and styling it with css.
        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(String.valueOf(getClass().getResource("style.css")));

        //        Register an action to the button.
        signIn.setOnAction(e -> {
            String curTxt = actionTarget.getText();
            actionTarget.setText(String.valueOf("Stage width: " + stage.getWidth() + "\nStage height: " + stage.getHeight()));
        });

        stage.setScene(scene);
        stage.setTitle("JavaFX Welcome!");
        stage.setMinHeight(300.0); // Minimum pixel of height no matter how much we shrink the stage.
        stage.setMinWidth(300.0); // Minimum pixel of width no matter how much we shrink the stage width.
        stage.show();
        stage.sizeToScene();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
