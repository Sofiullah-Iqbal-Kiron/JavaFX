package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class TriangleTimeLineToggleButton {
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/TriangleTimeLineToggleButton.fxml")).load();

    public TriangleTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);
    }
}
