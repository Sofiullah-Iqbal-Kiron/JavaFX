package com.example.helloearth.ChangeScene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class myScene2 extends Scene {
    private static Group group = new Group();
    private static Text text = new Text("Scene Two");

    public myScene2() {
        super(group);
        group.getChildren().add(text);
    }
}
