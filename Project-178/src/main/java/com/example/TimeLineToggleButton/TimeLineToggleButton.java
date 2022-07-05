package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class TimeLineToggleButton {

    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/TimeLineToggleButton.fxml")).load();

    public TimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);

        this.theButton.setMinSize(80, 80);

        String style = "-fx-background-color: #b3f7a9";
        this.theButton.setStyle(style);
    }
}
