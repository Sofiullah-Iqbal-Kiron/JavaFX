package com.example.PropertyOptionsHolder;

import com.example.project178.FilePath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.*;

public class SquarePropertyOptionsHolder extends VBox { // Should Extend PropertyOptionsHolder.
    public String side_length = "1.0", color = "#ffffff", position = "";
    private static String methodNextLine = "\n\t\t"; // Escape sequence of next line in construct method.

    public SquarePropertyOptionsHolder(String squareName, FileWriter writer, TextArea manimTerminal) {
        /*
         * A square have equal length in all side. Extends Rectangle so has all attribute as same as rectangle.
         * float side_length by a spinner 1-100, hexColor color, positioning.
         */

        Slider side_length_slider = new Slider(0.0f, 10.0f, 5.0f);
        side_length_slider.setShowTickLabels(true);
        side_length_slider.setShowTickMarks(true);
        side_length_slider.setMajorTickUnit(5);
        side_length_slider.setMinorTickCount(1);
        Label side_length_label = new Label("Side length: ");
        side_length_label.setLabelFor(side_length_slider);

        ColorPicker color_picker = new ColorPicker(Color.WHITE);
        //        Change the color value of current square instance when any color has been picked up from the color_picker.
        color_picker.setOnAction(e -> {
            String colorWebValueJFormat = color_picker.getValue().toString();
            color = "#" + color_picker.getValue().toString().strip().substring(2, colorWebValueJFormat.length() - 2);
        });

        ObservableList<String> animateOptions = FXCollections.observableArrayList("None", "Animate", "Built-In: ", "Create", "Transform", "Fading: ", "FadeOut", "FadeIn");
        ComboBox animate = new ComboBox(animateOptions);
        animate.setValue("None");

        Button done = new Button("Done");
        HBox doneHolder = new HBox();
        doneHolder.getChildren().add(done);
        doneHolder.setAlignment(Pos.BOTTOM_LEFT);
        done.setAlignment(Pos.BOTTOM_LEFT);
        done.setOnAction(e -> {
            //            write the codebase on py script.            //
            this.side_length = String.format("%.2f", side_length_slider.getValue()).strip();
            try {
                writer.append(squareName + " = Square(side_length=" + this.side_length + ", color=\"" + this.color + "\")" + methodNextLine);
                if (animate.getValue().toString().equals("None")) writer.append("self.add(" + squareName + ")");
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //            Run manim commands.            //
            String animateCommand = "manim -pql \"" + FilePath.manimScriptPath + "\" myScene";
            String msg = "";
            try {
                Process process = Runtime.getRuntime().exec(animateCommand);

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                while ((msg = reader.readLine()) != null) {
                    manimTerminal.appendText(msg);
                    System.out.println(msg);
                }
                while ((msg = stdError.readLine()) != null) {
                    // All the error text should be red.
                    manimTerminal.appendText(msg);
                    System.out.println(msg);
                }

                System.exit(0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        //        Configuring this.        //
        this.setPadding(new Insets(10));
        this.getChildren().addAll(side_length_slider, color_picker, animate, doneHolder);
    }
}