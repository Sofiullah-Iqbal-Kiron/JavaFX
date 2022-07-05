package com.example.project178;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.IOException;

// It should be a splitpane.
public class ManimTerminal extends TextArea {
    TextArea theManimTerminal = new FXMLLoader(getClass().getResource("FXML/ManimTerminal.fxml")).load();

    public ManimTerminal() throws IOException {
        this.theManimTerminal.setPrefSize(BottomPanel.WIDTH, BottomPanel.HEIGHT);
        this.theManimTerminal.setEditable(true);
        Color backgroundColor = Color.ANTIQUEWHITE;
        CornerRadii cornerRadii = new CornerRadii(10);
        Insets insets = new Insets(1);
        BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, cornerRadii, insets);
        Background background = new Background(backgroundFill);
        this.theManimTerminal.setBackground(background);
    }
}
