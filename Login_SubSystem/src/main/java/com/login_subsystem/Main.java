// JFX icon issues: https://kordamp.org/ikonli/#_coreui
// Or we can add this library when creating any jfx project at intellij idea.

package com.login_subsystem;

import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static Stage firstStage; // The main stage passed from Application.

    public static LoginData currentLoginData = new LoginData("none", "nothing");

    public static Scene home_scene;

    public static GridPane login_gridpane, register_gridpane;

    public static Notifier notifier;

    @Override
    public void start(Stage stage) throws IOException {
        firstStage = stage;

        String basic_home_VBox = "home_Vbox.fxml";
        String material_home_VBox = "home_VBox_material.fxml";
        VBox home_VBox = new FXMLLoader(getClass().getResource(material_home_VBox)).load();

        notifier = new Notifier("Hello, World!");
        home_scene = new Scene(home_VBox);

//        Setting amazon for stage using ikonli.
//        This FontIcon is subclass of Text which is also subclass of Node. So we can use this as like we use Node.
        /*FontIcon amazon = new FontIcon("cib-amazon:20:RED");
        FontIcon git = new FontIcon("cib-git:20:GREEN");
        home_VBox.getChildren().add(amazon);
        home_VBox.getChildren().add(git);*/

        stage.setTitle("User Authenticator");
        stage.setScene(home_scene);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /*private static void setLoginAndRegisterButtonOfHomeVBox(VBox container, Stage mainStage) throws IOException {
        login_gridpane = new FXMLLoader(Main.class.getResource("login_gridpane.fxml")).load();
        register_gridpane = new FXMLLoader(Main.class.getResource("register_gridpane.fxml")).load();

        Scene login_scene = new Scene(login_gridpane);
        Scene register_scene = new Scene(register_gridpane);

        for (Node n : container.getChildren())
            if (n instanceof Button b) {
                String buttonId = b.getId().strip();
                switch (buttonId) {
                    case "loginButton" -> b.setOnAction(e -> mainStage.setScene(login_scene));
                    case "registerButton" -> b.setOnAction(e -> mainStage.setScene(register_scene));
                }
            }
    }*/

    //    Now no need.
    private static void setLoginGridpane(GridPane pane) {
        TextField username = new TextField();
        PasswordField password = new PasswordField();
        Button submit = new Button();
        for (Node n : pane.getChildren()) {
            if (n.getId() != null) {
                String id = n.getId().strip();
                switch (id) {
                    case "username_textfield" -> username = (TextField) n;
                    case "password_passwordfield" -> password = (PasswordField) n;
                    case "submit_button" -> submit = (Button) n;
                }
            }
        }

        TextField finalUsername = username;
        PasswordField finalPassword = password;
        submit.setOnAction(e -> {
            LoginData currentLoginData = new LoginData(finalUsername.getText().strip().toLowerCase(), finalPassword.getText().strip());
            System.out.println(Validator.isValidCredentials(currentLoginData.getUsername(), currentLoginData.getPassword()) ? "User Authenticated." : "Invalid credentials!\nMay be username or password is wrong.");
        });
    }
}