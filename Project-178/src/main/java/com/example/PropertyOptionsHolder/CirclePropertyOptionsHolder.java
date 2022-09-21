package com.example.PropertyOptionsHolder;

import com.example.project178.FilePath;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CirclePropertyOptionsHolder extends VBox {
    public GridPane theCirclePropertyOptionsHolder = new FXMLLoader(getClass().getResource("CirclePropertyOptionsHolder.fxml")).load();
    public String radius = "1.0", color = "#fc6255", position = "ORIGIN", fill_opacity = "1";
    private static String methodNextLine = "\n\t\t"; // Escape sequence of next line in construct method.

    public CirclePropertyOptionsHolder(String circleName, FileWriter writer, FlowPane timeLineFlowPane) throws IOException {
        HBox radiusPropertyHolder = new HBox(2);
        Label radiusLabel = new Label("Radius: ");
        Slider radiusSlider = new Slider(1, 10, 1);
        radiusSlider.setShowTickLabels(true);
        radiusSlider.setShowTickMarks(true);
        radiusSlider.setMajorTickUnit(4);
        radiusPropertyHolder.getChildren().addAll(radiusLabel, radiusSlider);

        HBox colorPropertyHolder = new HBox(2);
        Label colorLabel = new Label("Color: ");
        ColorPicker colorPicker = new ColorPicker(Color.web(color));
        colorPicker.setOnAction(e -> {
            String colorInWebValueJFormat = colorPicker.getValue().toString();
            this.color = "#" + colorPicker.getValue().toString().strip().substring(2, colorInWebValueJFormat.length() - 2);
        });
        colorPropertyHolder.getChildren().addAll(colorLabel, colorPicker);

        HBox positionPropertyHolder = new HBox(2);
        Label positionLabel = new Label("Position: ");
        ObservableList<String> positionOptions = FXCollections.observableArrayList("Center: origin", "Left: 1 shift", "Right: 1 shift");
        ComboBox positionCombo = new ComboBox(positionOptions);
        positionPropertyHolder.getChildren().addAll(positionLabel, positionCombo);

        HBox animateOptionHolder = new HBox(2);
        Label animateLabel = new Label("Animation: ");
        ObservableList<String> animationOptions = FXCollections.observableArrayList("None", "Transform", "FadeOut");
        ComboBox animate = new ComboBox(animationOptions);
        animate.getSelectionModel().selectFirst();
        animateOptionHolder.getChildren().addAll(animateLabel, animate);

        FlowPane renderButtonHolder = new FlowPane();
        renderButtonHolder.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        Button render = new Button("Render");
        render.setTooltip(new Tooltip("Check configuration and press render to generate image/animation."));
        renderButtonHolder.getChildren().add(render);
        render.setOnAction(e -> {
            //            write the codebase on py script.            //
            this.radius = String.format("%.2f", radiusSlider.getValue()).strip();
            try {
                writer.append(circleName + " = Circle(radius=" + this.radius + ", color=\"" + this.color + "\")" + methodNextLine);
                if (animate.getValue().toString().equals("None")) writer.append("self.add(" + circleName + ")");
                else if (animate.getValue().toString().equals("Transform")) {
                    // animation script.
                    ObservableList<Node> objects = timeLineFlowPane.getChildren();
                    for (Node n : objects) {
                        if (n instanceof ToggleButton) {
                            if (n.getUserData().equals("Square")) {
                                writer.append("self.play(Transform(" + circleName + ", " + ((ToggleButton) n).getText() + "))");
                                break;
                            }
                        }
                    }
                }
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
                    System.out.println(msg);
                }
                while ((msg = stdError.readLine()) != null) {
                    // All the error text should be red.
                    System.out.println(msg);
                }

                System.exit(0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        this.setSpacing(4.0);
        this.setPadding(new Insets(5));
        this.getChildren().addAll(radiusPropertyHolder, colorPropertyHolder, positionPropertyHolder, animateOptionHolder, renderButtonHolder);
    }
}
