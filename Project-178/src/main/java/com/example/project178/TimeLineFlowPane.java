package com.example.project178;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.*;

import java.io.IOException;

/*
 * HBox of a set of mutually exclusive toggles.
 */
public class TimeLineFlowPane {
    public FlowPane theTimeLineFlowPane = new FXMLLoader(getClass().getResource("FXML/TimeLineFlowPane.fxml")).load();

    public TimeLineFlowPane() throws IOException {
        this.theTimeLineFlowPane.setHgap(8);
        this.theTimeLineFlowPane.setPrefSize(BottomPanel.WIDTH, BottomPanel.HEIGHT);
    }
}
