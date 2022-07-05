package com.example.RedefinedControls;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class RedefinedControls {
    public Button TimeLineToggleButton;

    public RedefinedControls() throws IOException {
        this.TimeLineToggleButton = new FXMLLoader(RedefinedControls.class.getResource("RedefinedButton.fxml")).load();
    }
}
