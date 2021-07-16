package com.uriegas;

import java.io.IOException;
import java.util.Optional;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
/**
 * JavaFX App
 */
public class MainApp extends Application {
    /**
     * Starts the JavaFx Application
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        //Load the Chat.fxml
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("Chat.fxml"));
        // loader.setLocation( new URL("file:/run/media/uriegas/384f8cf3-55e7-459b-8b18-17bc09944115/home/uriegas/Documents/MyProjects/Programacion/LearningJava/Chat-in-JavaFX/src/main/resources/Chat.fxml"));
        System.out.println(this.getClass().getResource("Chat.fxml"));
        Parent root = (Parent)loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Chat app");
        primaryStage.setScene(scene);
        /**
         * Alert: Exit Confirmation Window
         */
        primaryStage.setOnCloseRequest(event -> {
            Alert closeConfirmation = new Alert(
                Alert.AlertType.CONFIRMATION,
                "Are you sure you want to exit?"
            );
            Button exitButton = (Button) closeConfirmation.getDialogPane().lookupButton(ButtonType.OK);
            exitButton.setText("Exit");
            closeConfirmation.setHeaderText("Confirm Exit");
            closeConfirmation.initModality(Modality.APPLICATION_MODAL);
            closeConfirmation.initOwner(primaryStage);

            Optional<ButtonType> closeResponse = closeConfirmation.showAndWait();
            if (!ButtonType.OK.equals(closeResponse.get()))
                event.consume();
        });

        primaryStage.show();
    }
    /**
     * In a JavaFx project the main function is ignored
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Close the JavaFx App
     */
    @Override
    public void stop() {
        System.out.println("Stopping JavaFx App");
    }
}