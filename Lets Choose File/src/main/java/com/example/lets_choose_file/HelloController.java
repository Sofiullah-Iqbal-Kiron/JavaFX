package com.example.lets_choose_file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

public class HelloController {
    @FXML
    private Label mainLabel;

    @FXML
    protected void mainLabelHovered() {
        mainLabel.setFont(Font.font("Ubuntu Mono", 25));
    }
}