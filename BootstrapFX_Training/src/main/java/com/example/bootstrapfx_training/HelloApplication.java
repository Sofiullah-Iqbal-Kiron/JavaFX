package com.example.bootstrapfx_training;

/*
 * BootstrapFX is a partial port of Twitter Bootstrap for JavaFX.
 * We can get the latest version of BootstrapFX from maven central, stay online while creating project.
 * IntelliJ IDEA will load the repo automatically, just stay online.
 *
 * Can be build with gradle also.
 */

/*
 * Custom widget from BootstrapFX.
 * Apply CSS class to widgets.
 * Apply BootstrapFX stylesheet to scene.
 */

/*
 * Supported css classes: Button.
 * 1. btn
 * 2. btn-default, btn-primary, btn-success, btn-info, btn-warning, btn-danger
 * 3. btn-lg, btn-sm, btn-xs
 */

// And many more classes available, go to the GitHub repo to read the docs.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        //        Learning bootstrapfx.

        //        A custom panel from bootstrapfx.
        Panel panel = new Panel("1");
        panel.getStyleClass().setAll("panel-info");
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        Button button = new Button("Hello BootstrapFX");
        button.getStyleClass().setAll("btn", "btn-sm", "btn-danger");
        content.setCenter(button);
        panel.setBody(content);

        button.setOnAction(e -> panel.setText(String.valueOf(Integer.valueOf(panel.getText()) + 1)));

        Scene scene = new Scene(panel, 320, 240);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.setTitle("BootstrapFX");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}