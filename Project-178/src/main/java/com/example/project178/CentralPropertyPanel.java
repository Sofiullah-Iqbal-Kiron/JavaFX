package com.example.project178;

import com.example.PropertyOptionsHolder.PropertyOptionsHolder;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.IOException;

public class CentralPropertyPanel extends FlowPane {
    public CentralPropertyPanel() throws IOException {
        Label caption = new FXMLLoader(getClass().getResource("FXML/CentralPropertyPanel/Caption.fxml")).load();
        caption.setAlignment(Pos.TOP_CENTER);

        VBox propertyOptionsHolder = new PropertyOptionsHolder();

        propertyOptionsHolder.setPrefSize(caption.getMaxWidth(), 200);
        propertyOptionsHolder.setMaxSize(caption.getMaxWidth(), 210);

        this.setOrientation(Orientation.VERTICAL);
        this.setAlignment(Pos.TOP_CENTER);
        this.getChildren().addAll(caption, propertyOptionsHolder);
    }
}
