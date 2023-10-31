package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DataEntryScreen extends Application {

    private TextField immigrantNameEntry;
    private TextField immigrantAlienFianceEntry;

    @Override
    public void start(Stage primaryStage) {
        // Create a TextField for the first input
        immigrantNameEntry = new TextField();

        // Create a TextField for the second input
        immigrantAlienFianceEntry = new TextField();

        // Create a submit button
        Button submitButton = new Button("Submit");

        // Attach an event handler to the submit button
        submitButton.setOnAction(e -> switchToImmigrantAlienFiance());

        // Create a layout for the initial scene
        VBox immigrantNameVbox = new VBox(immigrantNameEntry, submitButton);
        Scene immigrantNameScene = new Scene(immigrantNameVbox, 300, 200);

        // Set the stage title
        primaryStage.setTitle("Immigrant Data Entry");

        // Set the initial scene
        primaryStage.setScene(immigrantNameScene);

        // Show the stage
        primaryStage.show();
    }

    // Method to switch to the "Immigrant Alien Fiancé" scene
    private void switchToImmigrantAlienFiance() {
        // Create a layout for the second scene
        VBox immigrantAlienFianceVbox = new VBox(immigrantAlienFianceEntry);
        Scene immigrantAlienFianceScene = new Scene(immigrantAlienFianceVbox, 300, 200);

        // Get the primaryStage and set the scene to the second scene
        Stage primaryStage = (Stage) immigrantNameEntry.getScene().getWindow();
        primaryStage.setScene(immigrantAlienFianceScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}