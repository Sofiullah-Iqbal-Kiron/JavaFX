package com.cse278;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    protected Text oid;

    @FXML
    protected Text dateOfIssueValue;

    @FXML
    private SplitPane mainSplitPane;

    @FXML
    private Label labelFrom, labelTo, labelSender, labelReceiver;

    @FXML
    private TextField senderName, senderNID, senderPhone, senderMail, receiverName, receiverNID, receiverPhone, receiverMail;

    @FXML
    private Button buttonPrint;

    @FXML
    public void dateOfIssueValue() {
        dateOfIssueValue.setText("Hey");
    }

    @FXML
    protected void printMemo() {
        // Print a latex document.

    }

    protected static void demo() {
        System.out.println("Hello from controller class");
    }
}