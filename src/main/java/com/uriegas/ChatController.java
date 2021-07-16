package com.uriegas;

import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.FileChooser;
/**
 * The controller for the chat application.
 */
public class ChatController {
	@FXML private Button sendFile;
	@FXML private TextField sendMessage;
	@FXML private TextArea chat;
	/**
	 * Initialization method.
	 */
	public void intialize() {
		sendFile.setOnAction(e -> {
			String fileName = sendFile.getText();
			FileChooser fc = new FileChooser();
			fc.setTitle("Select a file");
			File file = fc.showOpenDialog(null);
			if (file != null) {
				System.out.println("Sending file: " + fileName);
			}
		});
		//When ENTER is pressed, send the message
		sendMessage.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				sendMessage.getText();
				System.out.println("Sending message: " + sendMessage.getText());
			}
		});
	}
}
