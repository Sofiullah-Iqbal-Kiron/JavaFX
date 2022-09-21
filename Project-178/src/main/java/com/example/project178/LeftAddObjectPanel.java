package com.example.project178;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;

import java.io.IOException;

public class LeftAddObjectPanel extends VBox {
    VBox theLeftAddObjectPanel = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/theLeftAddObjectPanel.fxml")).load();

    //    private static int sqC = 1, cirC = 1, triC = 1, polyC = 1, arrC = 1, texC = 1, mtexC = 1;

    public LeftAddObjectPanel() throws IOException {
        //        Square, Circle, Triangle, Polygon, Arrow, Text, MathText.

        String iconDirURL = "C:\\Users\\Hp\\Documents\\Rich JavaFX\\Project-178\\src\\main\\resources\\com\\example\\project178\\ImageOrIcon\\AddObjectPanel\\";

        /*String squareURL = iconDirURL + "square2.jpg";
        ImageView square = new ImageView(new Image(squareURL));
        square.setFitHeight(20);
        square.setFitWidth(20);
        square.setSmooth(true);*/


        Button addSquare = new Button("Square");
        Rectangle SquareIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Square.fxml")).load();
        SquareIcon.setWidth(15);
        SquareIcon.setHeight(15);
        addSquare.setGraphic(SquareIcon);

        Button addCircle = new Button("Circle");
        Circle CircleIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Circle.fxml")).load();
        CircleIcon.setRadius(7.5);
        addCircle.setGraphic(CircleIcon);

        Button addTriangle = new Button("Triangle");
        Polygon TriangleIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Triangle.fxml")).load();
        addTriangle.setGraphic(TriangleIcon);

        Button addPolygon = new Button("Polygon");
        Polygon PolygonIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Polygon.fxml")).load();
        addPolygon.setGraphic(PolygonIcon);

        Button addArrow = new Button("Arrow");
        HBox ArrowIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Arrow.fxml")).load();
        ArrowIcon.setMaxSize(15, 15);
        addArrow.setGraphic(ArrowIcon);

        Button addText = new Button("Text");
        Shape TextIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/Text.fxml")).load();
        addText.setGraphic(TextIcon);

        Button addMathText = new Button("MathText");
        Shape MathTextIcon = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/MathText.fxml")).load();
        addMathText.setGraphic(MathTextIcon);

        VBox addButtonsHolder = new FXMLLoader(getClass().getResource("FXML/AddObjectPanel.fxml")).load();

        //        Configuring addButtonsHolder.
        addButtonsHolder.setSpacing(6);
        addButtonsHolder.setPadding(new Insets(5));
        addButtonsHolder.setId("AddButtonsHolder");
        addButtonsHolder.getStylesheets().add(getClass().getResource("StyleSheet/AddObjectPanel.css").toExternalForm());

        addButtonsHolder.getChildren().addAll(addSquare, addCircle, addTriangle, addPolygon, addArrow, addText, addMathText);
        for (Node b : addButtonsHolder.getChildren())
            if (b instanceof Button button) button.setGraphicTextGap(8.10);

        //        Configuring this.
        /*this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.setBackground(new Background(new BackgroundFill(Color.AZURE, new CornerRadii(10), new Insets(1))));*/
        Label TopLabel = new FXMLLoader(getClass().getResource("FXML/LeftAddObjectPanel/TopLabel.fxml")).load();
        this.theLeftAddObjectPanel.getChildren().addAll(TopLabel, addButtonsHolder);
    }
}
