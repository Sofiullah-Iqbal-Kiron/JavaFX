package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class TextTimeLineToggleButton{
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/TextTimeLineToggleButton.fxml")).load();

    public TextTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);
    }
}
