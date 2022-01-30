// Switch between scenes when the SwitcH button has been fired.

package com.example.helloearth.ChangeScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class ChangeSceneOnButtonClick extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        myScene1 s1 = new myScene1();
        myScene2 s2 = new myScene2();
        SwitcHButton b = new SwitcHButton();
    }
}