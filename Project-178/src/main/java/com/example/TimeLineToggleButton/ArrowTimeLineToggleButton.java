package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class ArrowTimeLineToggleButton{
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/ArrowTimeLineToggleButton.fxml")).load();

    public ArrowTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);
    }
}
