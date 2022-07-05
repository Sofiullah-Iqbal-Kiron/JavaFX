package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToggleButton;

import java.io.IOException;

public class PolygonTimeLineToggleButton{
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/PolygonTimeLineToggleButton.fxml")).load();

    public PolygonTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);
    }
}
