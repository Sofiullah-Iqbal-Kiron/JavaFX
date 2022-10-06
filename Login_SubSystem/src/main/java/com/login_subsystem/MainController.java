// This class is controller for: "home_VBox.fxml", "login_gridpane.fxml", "register_gridpane.fxml".

package com.login_subsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.controlsfx.control.Notifications;

import java.io.IOException;

public class MainController {
    @FXML
    private TextField username_textfield;

    @FXML
    private PasswordField password_passwordfield;

    @FXML
    protected void bringLoginPanel() throws IOException {
        Main.login_gridpane = new FXMLLoader(Main.class.getResource("login_gridpane.fxml")).load();
        Scene login_scene = new Scene(Main.login_gridpane);
        Main.firstStage.setScene(login_scene);
        Main.firstStage.sizeToScene();
    }

    @FXML
    protected void bringRegistrationPanel() throws IOException {
        Main.register_gridpane = new FXMLLoader(Main.class.getResource("register_gridpane.fxml")).load();
        Scene register_scene = new Scene(Main.register_gridpane);
        Main.firstStage.setScene(register_scene);
        Main.firstStage.sizeToScene();
    }

    @FXML
    protected void checkCredentials() {
        Main.currentLoginData = new LoginData(username_textfield.getText().strip().toLowerCase(), password_passwordfield.getText().strip());
//        System.out.println(Validator.isValidCredentials(Main.currentLoginData.getUsername(), Main.currentLoginData.getPassword()) ? "User Authenticated." : "Invalid credentials!\nMay be username or password is wrong.");
//        Is valid, then bring a dialog pane of "OK". This DialogPane is of Main.
        String message;
        if (Validator.isValidCredentials(Main.currentLoginData.getUsername(), Main.currentLoginData.getPassword()))
            message = "User Authenticated.";
        else message = "Invalid credentials!\nMay be username or password is wrong.";
        Notifications notifications = Notifications.create().title("from \"User Authenticator\"").text(message).darkStyle();
        notifications.showInformation();
    }

    @FXML
    protected void goToHome() {
        Main.firstStage.setScene(Main.home_scene);
        Main.firstStage.sizeToScene();
    }
}