package com.example.PropertyOptionsHolder;

import com.example.project178.FilePath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextPropertyOptionsHolder {
    public GridPane theTextPropertyOptionsHolder = new FXMLLoader(getClass().getResource("TextPropertyOptionsHolder.fxml")).load();
    private static String methodNextLine = "\n\t\t"; // Escape sequence of next line in construct method.

    public TextPropertyOptionsHolder(String textName, FileWriter writer, TextArea manimTerminal) throws IOException {
        TextField text = null;
        Slider fill_opacity = null;
        ColorPicker color = null;
        ComboBox<Integer> font_size = null;
        ComboBox<String> font = null, weight = null;
        Button render = null;

        for (Node n : this.theTextPropertyOptionsHolder.getChildren()) {
            if (n instanceof Text) continue;
            else if (n instanceof TextField t)
                text = t;
            else if (n instanceof Slider s) fill_opacity = s;
            else if (n instanceof ColorPicker cp) color = cp;
            else if (n instanceof ComboBox cb) {
                String cbID = cb.getId();
                switch (cbID) {
                    case "font_size":
                        font_size = cb;
                        ObservableList<Integer> font_sizes = FXCollections.observableArrayList(1, 2, 4, 5, 6, 8, 9, 10, 11, 13, 14, 15, 16, 18, 20, 22, 25, 30, 35, 40, 48, 50, 60, 70, 72, 100);
                        font_size.setEditable(true);
                        font_size.setItems(font_sizes);
                        font_size.getSelectionModel().selectFirst();
                        break;
                    case "font":
                        font = cb;
                        ObservableList<String> fonts = FXCollections.observableArrayList();
                        fonts.addAll(Font.getFontNames());
                        font.setItems(fonts);
                        font.setEditable(true);
                        font.getSelectionModel().selectFirst();
                        break;
                    case "weight":
                        weight = cb;
                        ObservableList<String> weights = FXCollections.observableArrayList("THIN", "ULTRALIGHT", "LIGHT", "BOOK", "NORMAL", "MEDIUM", "SEMIBOLD", "BOLD", "ULTRABOLD", "HEAVY", "ULTRAHEAVY");
                        weight.setEditable(true);
                        weight.setItems(weights);
                        weight.getSelectionModel().selectFirst();
                        break;
                }
            } else if (n instanceof Button b) render = b;
        }

        TextField finalText = text;
        Slider finalFill_opacity = fill_opacity;
        ComboBox finalFont_size = font_size;
        ComboBox finalFont = font;
        ComboBox finalWeight = weight;

        final String[] colorInWebForm = new String[1];
        //        Change the color value of current square instance when any color has been picked up from the color_picker.
        ColorPicker finalColor = color;
        color.setOnAction(e -> {
            String colorWebValueJFormat = finalColor.getValue().toString();
            colorInWebForm[0] = "#" + finalColor.getValue().toString().strip().substring(2, colorWebValueJFormat.length() - 2);
        });

        render.setOnAction(e -> {
            //            write the codebase on py script.            //
            try {
                writer.append(textName + " = Text('" + finalText.getText() + "', fill_opacity=" + finalFill_opacity.getValue() + ", color='" + colorInWebForm[0] + "', font_size=" + finalFont_size.getSelectionModel().getSelectedItem().toString().strip() + ", font='" + finalFont.getSelectionModel().getSelectedItem().toString().strip() + "', weight='" + finalWeight.getSelectionModel().getSelectedItem().toString().strip() + "')" + methodNextLine);
                writer.append("self.add(" + textName + ")");
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
    }
}
