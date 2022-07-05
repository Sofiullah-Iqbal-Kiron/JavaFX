package com.example.TimeLineToggleButton;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class SquareTimeLineToggleButton {
    public ToggleButton theButton = new FXMLLoader(getClass().getResource("FXML/SquareTimeLineToggleButton.fxml")).load();

    public SquareTimeLineToggleButton(String name) throws IOException {
        this.theButton.setText(name);

        /*Image iconImage = new Image("C:\\Users\\Hp\\Documents\\Rich JavaFX\\Project-178\\src\\main\\resources\\com\\example\\project178\\ImageOrIcon\\AddObjectPanel\\square2.jpg");
        ImageView icon = new ImageView(iconImage);
        icon.setFitWidth(20);
        icon.setFitHeight(20);
        this.theButton.setGraphic(icon);*/
    }
}
