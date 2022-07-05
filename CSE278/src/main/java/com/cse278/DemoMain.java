package com.cse278;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DemoMain extends Application {
    private static double mainStageCurrentHeight = 0.0;

    @Override
    public void start(Stage stage) throws IOException {
        StackPane root = new FXMLLoader(getClass().getResource("MainStackPane.fxml")).load();
        Scene scene = new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

//        Child of root stackPane.
        HBox welcomePage = new FXMLLoader(getClass().getResource("WelcomePage.fxml")).load();
        welcomePage.setVisible(true);

        VBox newOrderForm = new FXMLLoader(getClass().getResource("NewOrderForm.fxml")).load();
        newOrderForm.setVisible(false);

//        welcomePage
        Button trackYourOrder = null, newOrder = null;
        for (Node button : welcomePage.getChildren()) {
            if (button.getId() == "trackYourOrder") trackYourOrder = (Button) button;
            else if (button.getId() == "newOrder") newOrder = (Button) button;
        }
        newOrder.setOnAction(e -> {
            welcomePage.setVisible(false);
            newOrderForm.setVisible(true);
        });

//        newOrderForm


//        add child welcomePage, newOrderForm to the top level stackPane.
        root.getChildren().addAll(welcomePage, newOrderForm);


//        Setting stage, the main top level container.
        stage.setScene(scene);
        setStage(stage);
    }

    private void setStage(Stage stage) {
        stage.setTitle("Halogen Transport Agency");

        Image stageIcon = new Image(String.valueOf(getClass().getResource("Icon.jpg")));
        stage.getIcons().add(stageIcon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}