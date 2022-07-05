package com.example.project178;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class BottomPanel {
    public static int WIDTH = 400;
    public static int HEIGHT = 100;
    public VBox theBottomPanel = new FXMLLoader(getClass().getResource("FXML/BottomPanel.fxml")).load();

    public BottomPanel() throws IOException {
    }
}
