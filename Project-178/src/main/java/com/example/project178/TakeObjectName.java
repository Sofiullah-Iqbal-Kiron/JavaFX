package com.example.project178;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;

import java.io.IOException;

public class TakeObjectName extends TextInputDialog {
    DialogPane theTakeObjectName = new FXMLLoader(getClass().getResource("FXML/TakeObjectName.fxml")).load();

    public TakeObjectName() throws IOException {
        this.setContentText("Input a unique name for the object.");
        this.setHeaderText("Object Name");
        this.setResizable(true);
        this.initModality(Modality.APPLICATION_MODAL);
    }
}
