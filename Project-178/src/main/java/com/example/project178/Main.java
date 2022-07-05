package com.example.project178;

import com.example.PropertyOptionsHolder.CirclePropertyOptionsHolder;
import com.example.PropertyOptionsHolder.SquarePropertyOptionsHolder;
import com.example.PropertyOptionsHolder.TrianglePropertyOptionsHolder;
import com.example.TimeLineToggleButton.CircleTimeLineToggleButton;
import com.example.TimeLineToggleButton.SquareTimeLineToggleButton;
import com.example.TimeLineToggleButton.TriangleTimeLineToggleButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //        Create the basic manim script.        //
        File source = new File(FilePath.manimScriptPath);
        FileWriter writer = new FileWriter(source);
        String methodNextLine = "\n\t\t"; // Escape sequence of next line in construct method.
        String basicStructure = "from manim import *\n\nimport numpy as np\n\n\nclass myScene(Scene):\n\tdef construct(self):" + methodNextLine;

        try {
            source.createNewFile();
            writer.write(basicStructure);
        } catch (IOException e2) {
            System.out.println(e2.getLocalizedMessage());
            e2.printStackTrace();
        }

        //        Constructing root for the scene.
        BorderPane rootBorderPane = new FXMLLoader(getClass().getResource("FXML/Main.fxml")).load();
        rootBorderPane.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        //        Children of mainBorderPane.        //
        //        Top: topMenuBar
        TopMenuBar topMenuBar = new TopMenuBar();

        //        Left: leftAddObjectPanel
        VBox leftAddObjectPanel = new LeftAddObjectPanel().theLeftAddObjectPanel;

        //        Bottom: timeLineFlowPane and manimTerminal in a VBox.
        VBox bottomPanel = new BottomPanel().theBottomPanel;
        FlowPane timeLineFlowPane = new TimeLineFlowPane().theTimeLineFlowPane;
        TextArea manimTerminal = new ManimTerminal().theManimTerminal;
        bottomPanel.getChildren().addAll(timeLineFlowPane, manimTerminal); // timeLineFlowPane, manimTerminal

        //        Center: centralPropertyPanel with while noObjectSelectedFromTimeLine message.
        CentralPropertyPanel centralPropertyPanel = new CentralPropertyPanel();
        Text noObjectSelectedFromTimeLine = new FXMLLoader(getClass().getResource("FXML/NoObjectSelectedFromTimeLine.fxml")).load();
        VBox noObjectSelectedFromTimeLineHolder = new VBox();
        noObjectSelectedFromTimeLineHolder.setPadding(new Insets(10));
        noObjectSelectedFromTimeLineHolder.getChildren().add(noObjectSelectedFromTimeLine);

        rootBorderPane.setTop(topMenuBar);
        rootBorderPane.setBottom(bottomPanel);
        rootBorderPane.setCenter(centralPropertyPanel);
        rootBorderPane.setLeft(leftAddObjectPanel);

        //        Dialog that takes a unique name for the object by checking regex in "Set<String> objectName".
        Set<String> objectsName = new HashSet<>();
        TakeObjectName takeObjectName = new TakeObjectName();

        VBox leftAddObjectPanelsVBox = null;
        if (leftAddObjectPanel.getChildren().get(1) instanceof VBox)
            leftAddObjectPanelsVBox = (VBox) leftAddObjectPanel.getChildren().get(1);

        ToggleGroup toggleGroupAtBottomTimeLineFlowPane = new ToggleGroup();
        for (Node node : leftAddObjectPanelsVBox.getChildren()) {
            if (node instanceof Button theButton) {
                theButton.setOnAction(e -> {
                    String currentObjectClass = theButton.getText();
                    takeObjectName.setHeaderText(currentObjectClass + " Name ");
                    takeObjectName.setContentText("Insert a unique name for this " + currentObjectClass.toLowerCase() + ": ");
                    takeObjectName.showAndWait();
                    String currentObjectName = takeObjectName.getEditor().getText().strip();
                    //                    Check that the name does not contain any unvalid token of python.
                    /*//                    Check that given name is unique.
                    ObservableList togglesInBottomTimeLineFlowPane = timeLineFlowPane.getChildren();
                    int len = togglesInBottomTimeLineFlowPane.size();
                    String[] nameOfTogglesInBottomTimeLineHBox = new String[len];
                    for(int i = 0; i < len; i++) {
                        nameOfTogglesInBottomTimeLineHBox[i] = (ToggleButton)togglesInBottomTimeLineFlowPane.get(i).getText();
                    }*/
                    boolean uniqueObjectNameInserted = objectsName.add(currentObjectName);
                    if (!Objects.equals(currentObjectName, "") && uniqueObjectNameInserted) {
                        switch (currentObjectClass) {
                            case "Square":
                                try {
                                    ToggleButton tSquare = new SquareTimeLineToggleButton(currentObjectName).theButton;
                                    tSquare.setUserData("Square");

                                    tSquare.setAccessibleText(currentObjectName);
                                    tSquare.setToggleGroup(toggleGroupAtBottomTimeLineFlowPane);
                                    timeLineFlowPane.getChildren().add(tSquare);
                                    // If selected then unselect and if nothing is selected in the togglegroup then setLabel of centralpropertypanel "no object selected."
                                    // Set changeListener instead of setOnAction.
                                    tSquare.setOnAction(action -> {
                                        centralPropertyPanel.getChildren().set(1, new SquarePropertyOptionsHolder(currentObjectName, writer, manimTerminal));
                                        stage.sizeToScene();
                                    });
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case "Circle":
                                try {
                                    ToggleButton tCircle = new CircleTimeLineToggleButton(currentObjectName).theButton;
                                    tCircle.setAccessibleText(currentObjectName);
                                    tCircle.setToggleGroup(toggleGroupAtBottomTimeLineFlowPane);
                                    timeLineFlowPane.getChildren().add(tCircle);
                                    tCircle.setOnAction(action -> {
                                        centralPropertyPanel.getChildren().set(1, new CirclePropertyOptionsHolder(currentObjectName, writer, timeLineFlowPane));
                                        stage.sizeToScene();
                                    });
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                            case "Triangle":
                                try {
                                    ToggleButton tTriangle = new TriangleTimeLineToggleButton(currentObjectName).theButton;
                                    tTriangle.setAccessibleText(currentObjectName);
                                    tTriangle.setToggleGroup(toggleGroupAtBottomTimeLineFlowPane);
                                    timeLineFlowPane.getChildren().add(tTriangle);
                                    tTriangle.setOnAction(action -> {
                                        centralPropertyPanel.getChildren().set(1, new TrianglePropertyOptionsHolder());
                                        stage.sizeToScene();
                                    });
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                break;
                        }
                    } else if (!uniqueObjectNameInserted) {
                        Alert myAlert = new Alert(Alert.AlertType.ERROR);
                        myAlert.setContentText("Please insert an unique object name.");
                        myAlert.showAndWait();
                        takeObjectName.showAndWait();
                    } else {
                        //                        Bring alert box. Object name can not be empty/null.
                        Alert myAlert = new Alert(Alert.AlertType.ERROR);
                        myAlert.setContentText("Object name can not be empty.");
                        myAlert.showAndWait();
                        takeObjectName.showAndWait();
                    }
                    takeObjectName.getEditor().clear();
                });
            }
        }

        // While none of the TimeLineToggleButton is selected.
        if (toggleGroupAtBottomTimeLineFlowPane.getSelectedToggle() == null) {
            centralPropertyPanel.getChildren().set(1, noObjectSelectedFromTimeLineHolder);
        }

        //        Stage and it's main scene setting.        //[
        {
            Scene scene = new Scene(rootBorderPane);
            stage.setTitle("Object Animation Creator");
            stage.setScene(scene);
            stage.sizeToScene();
            stage.setResizable(true);
            stage.setAlwaysOnTop(false); // Don't inverse it to true, if you did this then TakeObjectName dialog will not show properly.
            stage.show();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}