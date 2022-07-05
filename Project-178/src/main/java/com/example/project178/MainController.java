package com.example.project178;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.*;

public class MainController {
    @FXML
    private Button create;

    @FXML
    protected void createClicked(ActionEvent e) {
        if(e.getSource().equals(create)) {
            File source = new File("C:\\Users\\Hp\\Documents\\JavaFX\\Project-178\\src\\main\\resources\\com\\example\\project178\\Manim\\source.py");
            String methodNextLine = "\n\t\t"; // Escape sequence of next line in construct method.
            String basicStructure = "from manim import *\n\nimport numpy as np\n\n\nclass myScene(Scene):\n\tdef construct(self):\n\t\tisosceles = Polygon([-5, 1.5, 0], [-2, 1.5, 0], [-3.5, -2, 0])\n\t\tposition_list = [[4, 1, 0], [4, -2.5, 0], [0, -2.5, 0], [0, 3, 0], [2, 1, 0], [4, 3, 0]]\n\t\tsquare_and_triangles = Polygon(*position_list, color=PURPLE_B)\n\t\tself.add(isosceles, square_and_triangles)\n\t\t";

            try {
                source.createNewFile();
                FileWriter writer = new FileWriter(source);
                writer.write(basicStructure);
                writer.close();
            } catch(IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    @FXML
    protected void sceneClicked(ActionEvent e) {
        String animateCommand = "manim -pql \"C:\\Users\\Hp\\Documents\\Rich JavaFX\\Project-178\\src\\main\\resources\\com\\example\\project178\\Manim\\source.py\" myScene";
        String msg = "";
        try {
            Process process = Runtime.getRuntime().exec(animateCommand);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            while((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
            while((msg = stdError.readLine()) != null) {
                System.out.println(msg);
            }

            System.exit(0);
        } catch(IOException e1) {
            e1.printStackTrace();
        }
    }
}