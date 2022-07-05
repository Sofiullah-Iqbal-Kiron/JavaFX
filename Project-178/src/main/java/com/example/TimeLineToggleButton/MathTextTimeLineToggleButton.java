package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class MathTextTimeLineToggleButton{
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/MathTextTimeLineToggleButton.fxml")).load();

    public MathTextTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);
    }
}
