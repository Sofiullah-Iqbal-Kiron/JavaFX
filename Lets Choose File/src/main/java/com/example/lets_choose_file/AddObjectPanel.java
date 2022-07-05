package com.example.lets_choose_file;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class AddObjectPanel extends VBox {
    public AddObjectPanel() {
        //        Square, Circle, Triangle, Polygon, Arrow, Text, MathText.

        String imagesFolderURL = "C:\\Users\\Hp\\Documents\\JavaFX\\Lets Choose File\\src\\main\\resources\\com\\example\\lets_choose_file\\Images\\";

        String squareURL = imagesFolderURL + "square2.jpg";
        ImageView square = new ImageView(new Image(squareURL));
        square.setFitHeight(20);
        square.setFitWidth(20);
        square.setSmooth(true);

        String circleURL = imagesFolderURL + "circle.png";
        ImageView circle = new ImageView(new Image(circleURL));
        circle.setFitHeight(20);
        circle.setFitWidth(20);
        circle.setSmooth(true);

        String triangleURL = imagesFolderURL + "";
        ImageView triangle = new ImageView();

        String polygonURL = imagesFolderURL + "";
        ImageView polygon = new ImageView();

        String arrowURL = imagesFolderURL + "";
        ImageView arrow = new ImageView();

        String textURL = imagesFolderURL + "";
        ImageView text = new ImageView();

        String mathTextURL = imagesFolderURL + "";
        ImageView mathText = new ImageView();

        Button addSquare = new Button("Square", square);
        Button addCircle = new Button("Circle", circle);
        Button addTriangle = new Button("Triangle", triangle);
        Button addPolygon = new Button("Polygon", polygon);
        Button addArrow = new Button("Arrow", arrow);
        Button addText = new Button("Text", text);
        Button addMathText = new Button("Mathematical Text", mathText);

        this.getChildren().addAll(addSquare, addCircle, addTriangle, addPolygon, addArrow, addText, addMathText);
    }
}

//package com.example.project178;
//
//
//        import javafx.scene.control.Button;
//        import javafx.scene.image.Image;
//        import javafx.scene.image.ImageView;
//        import javafx.scene.layout.VBox;
//
//        import java.io.IOException;
//
//public class AddObjectPanel extends VBox {
//    public AddObjectPanel() throws IOException {
//        //        Square, Circle, Triangle, Polygon, Arrow, Text, MathText.
//
//        //        iconDirURL: URL of the directory/folder that retain icons for AddObjectPanel.
//        String iconDirURL = "C:\\Users\\Hp\\Documents\\JavaFX\\Project-178\\src\\main\\resources\\com\\example\\project178\\ImageOrIcon\\AddObjectPanel\\";
//
//        String squareURL = iconDirURL + "square2.jpg";
//        ImageView square = new ImageView(new Image(squareURL));
//        square.setFitHeight(20);
//        square.setFitWidth(20);
//        square.setSmooth(true);
//
//        String circleURL = iconDirURL + "circle.png";
//        ImageView circle = new ImageView(new Image(circleURL));
//        circle.setFitHeight(20);
//        circle.setFitWidth(20);
//        circle.setSmooth(true);
//
//        String triangleURL = iconDirURL + "";
//        ImageView triangle = new ImageView();
//
//        String polygonURL = iconDirURL + "";
//        ImageView polygon = new ImageView();
//
//        String arrowURL = iconDirURL + "";
//        ImageView arrow = new ImageView();
//
//        String textURL = iconDirURL + "";
//        ImageView text = new ImageView();
//
//        String mathTextURL = iconDirURL + "";
//        ImageView mathText = new ImageView();
//
//        Button addSquare = new Button("Square", square);
//        Button addCircle = new Button("Circle", circle);
//        Button addTriangle = new Button("Triangle", triangle);
//        Button addPolygon = new Button("Polygon", polygon);
//        Button addArrow = new Button("Arrow", arrow);
//        Button addText = new Button("Text", text);
//        Button addMathText = new Button("Mathematical Text", mathText);
//
//        this.getChildren().addAll(addSquare, addCircle, addTriangle, addPolygon, addArrow, addText, addMathText);
//    }
//}