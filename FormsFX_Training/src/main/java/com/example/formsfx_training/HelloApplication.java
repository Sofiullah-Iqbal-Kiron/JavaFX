package com.example.formsfx_training;

/*
 * FormsFX enables developer to create forms with ease.
 * Creating forms in JavaFX is a tedious and very error-prone task.
 * FormsFX is a framework which solves this problem.
 */

import com.dlsc.formsfx.model.structure.*;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 500, 300);

        //        Create a login form using FormsFX which is a framework of javafx.

//        Field userName = Field.ofStringType("default").label("Username: ").tooltip("Your username.").span(12);
//        Field password = Field.ofPasswordType("default").label("Password: ").required("This field can't be empty");
//        Field age = Field.ofIntegerType(21);
//        Field isMarried = Field.ofBooleanType(false).label("Married? ").tooltip("Are you married?");
//        Field today = Field.ofDate(LocalDate.now());
//        Group g = Group.of(userName, password, age, isMarried, today);
//        Form loginForm = Form.of(g);
//        VBox renderer = new FormRenderer(loginForm);
//        renderer.setPrefSize(400, 300);
//        pane.getChildren().add(renderer);

        FlowPane flowPane = new FlowPane();
        Label myName = new Label("Kiron: ");
        Field userKiron = Field.ofStringType("").tooltip("You name.");

        flowPane.getChildren().addAll(myName, new FormRenderer(Form.of(Group.of(userKiron))));
        pane.getChildren().add(flowPane);

        stage.setTitle("FormsFX training");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}