/* @FXML annotation is used to tag non-public controller member fields and handler methods for use by FXML markup. */

package com.example.sampleforms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {
	@FXML
	private Label actionTarget;

	@FXML
	private TextField username_textfield;

	@FXML
	private GridPane sceneRoot;

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {
		if (event.getSource() instanceof Button)
			actionTarget.setText("Your name is: " + username_textfield.getText().strip());
	}

	@FXML
	protected void contextRequested() {
		username_textfield.setText("Context menu requested.");
	}

	@FXML
	private TextField firstName, lastName, number;

	@FXML
	private FlowPane contacts;

	@FXML
	protected void addContact() {
		String value = firstName.getText() + " " + lastName.getText() + "- " + number.getText();
		contacts.getChildren().add(new Text(value.strip()));
		firstName.clear();
		lastName.clear();
		number.clear();
	}

	@FXML
	protected void bringContext() {
		System.out.println("Context Requested.");
	}

	@FXML
	protected void mouseClicked() {
		System.out.println("Mouse Clicked.");
	}

	@FXML
	protected void mouseDragged() {
		System.out.println("Mouse Dragged.");
	}

	@FXML
	protected void mouseEntered() {
		System.out.println("Mouse Entered.");
	}
}