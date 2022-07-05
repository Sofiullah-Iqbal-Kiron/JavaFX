package com.example.lets_choose_file;

import com.example.RedefinedControls.RedefinedControls;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ColorPickerDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        root.setSpacing(10);
        Scene scene = new Scene(root, 300, 300);

        Text myName = new Text("KIRON");
        myName.setFont(Font.font("Ubuntu Mono", 20));
        myName.setFill(Color.RED);

        ColorPicker colorPicker = new ColorPicker(Color.ALICEBLUE);
        colorPicker.setOnAction(e -> {
            root.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), new CornerRadii(1), new Insets(1))));
            String colorWebValueJFormat = colorPicker.getValue().toString(); // Color from colorpicker in web format of java represented.
            System.out.println("#" + colorPicker.getValue().toString().strip().substring(2, colorWebValueJFormat.length() - 2));
        });

        Button tltb=new RedefinedControls().TimeLineToggleButton;
        tltb.setOnAction(e-> System.out.println("HEllo"));
        root.getChildren().addAll(colorPicker, myName, new RedefinedControls().TimeLineToggleButton, new RedefinedControls().TimeLineToggleButton,tltb);

        stage.setTitle("Color Picker Demonstration");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.sizeToScene();
        stage.show();
    }
}
