// FXML is an XML-based language that provides the structure for building a user interface separate from the application logic.


package com.example.sampleforms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(String.valueOf(getClass().getResource("MainStyle.css")));

//        Stage setting.
		stage.setTitle("Your contacts");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setResizable(true);
		stage.setAlwaysOnTop(true);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}