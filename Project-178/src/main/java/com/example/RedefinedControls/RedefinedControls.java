package com.example.RedefinedControls;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class RedefinedControls {
    // static variable can be used only one time. try to use as a class object.
    public ToggleButton TimeLineToggleButton;

    public RedefinedControls() throws IOException {
        this.TimeLineToggleButton = new FXMLLoader(RedefinedControls.class.getResource("TimeLineToggleButton.fxml")).load();
    }
}
