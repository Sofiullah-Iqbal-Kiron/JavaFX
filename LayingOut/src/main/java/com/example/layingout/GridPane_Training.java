package com.example.layingout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPane_Training extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 380, 150, Color.WHITE);

        //        FlowPane.
        //        Styling flowpane using css based stylesheet.
        FlowPane topBanner = new FlowPane();
        String topBannerStyle = "-fx-background-color: lightblue; -fx-background-radius: 30%; -fx-bacdground-inset: 5px";
        topBanner.setStyle(topBannerStyle);
        topBanner.getChildren().add(new Text("Hello"));
        root.setTop(topBanner);

        //        Constructing grid pane.
        GridPane pane = new GridPane();
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(5));
        pane.setHgap(5);
        pane.setVgap(5);
        //        To explicitly control the size of rows and columns: use RowConstrains and ColumnConstrains.
        //        Using ColumnConstrains to fix the size of a particular column.
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        column2.setHgrow(Priority.ALWAYS);
        pane.getColumnConstraints().addAll(column1, column2);

        Label fNameLbl = new Label("First Name");
        TextField fNameFld = new TextField();
        Label lNameLbl = new Label("Last Name");
        TextField lNameFld = new TextField();
        Button save = new Button("Save");

        stage.setTitle("Layout: GridPane");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
