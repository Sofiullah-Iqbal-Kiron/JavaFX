package com.example.PropertyOptionsHolder;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class PropertyOptionsHolder extends VBox {
    public PropertyOptionsHolder() {
        Background background = new Background(new BackgroundFill(Color.WHEAT, new CornerRadii(5), Insets.EMPTY));
        this.setBackground(background);
    }
}
