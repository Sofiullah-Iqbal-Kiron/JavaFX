package com.login_subsystem;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterGridPaneController {
    @FXML
    private TextField first_name, last_name, user_name, mail;

    @FXML
    private PasswordField password_field;

    @FXML
    protected void goToHome() {
        Main.firstStage.setScene(Main.home_scene);
        Main.firstStage.sizeToScene();
    }

    @FXML
    protected void selectFullFirstName() {
        first_name.selectAll();
    }

    @FXML
    protected void selectFullLastName() {
        last_name.selectAll();
    }

    @FXML
    protected void selectFullUserName() {
        user_name.selectAll();
    }

    @FXML
    protected void selectFullMail() {
        mail.selectAll();
    }

    @FXML
    protected void selectFullPassword() {
        password_field.selectAll();
    }

    @FXML
    protected void focusOnLastnameField() {
        last_name.requestFocus();
        last_name.selectAll();
    }

    @FXML
    protected void focusOnUsernameField() {
        user_name.requestFocus();
        user_name.selectAll();
    }

    @FXML
    protected void focusOnMailField() {
        mail.requestFocus();
        mail.selectAll();
    }

    @FXML
    protected void focusOnPasswordField() {
        password_field.requestFocus();
    }

    @FXML
    protected void register_the_user() {
//        Check the mail and password using Validator class.
        System.out.println("Name: " + first_name.getText().strip() + " " + last_name.getText().strip());
        System.out.println("Mail: " + mail.getText().strip());
        System.out.println("User registered.");
    }
}
