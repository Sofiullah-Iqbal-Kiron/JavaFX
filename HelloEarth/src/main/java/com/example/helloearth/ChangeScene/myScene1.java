package com.example.helloearth.ChangeScene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class myScene1 extends Scene {
    private static Group group = new Group();
    private static Text text = new Text("Scene One");

    public myScene1() {
        super(group);
        group.getChildren().add(text);
    }
}
