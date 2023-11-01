package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DataEntryScreen extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Immigrant Petition Form");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Text fields
        TextField petitionerNameField = new TextField();
        TextField alienFianceeNameField = new TextField();
        TextField alienChildrenNamesField = new TextField();
        TextField isValidANumberField = new TextField();
        TextField isValidEmailField = new TextField();
        TextField isValidDOBField = new TextField();

        // Add components to grid
        grid.add(new Label("Enter your Name:"), 0, 0);
        grid.add(petitionerNameField, 1, 0);
        grid.add(new Label("Enter your Fiancee's Name:"), 0, 1);
        grid.add(alienFianceeNameField, 1, 1);
        grid.add(new Label("Enter your children's name(s):"), 0, 2);
        grid.add(alienChildrenNamesField, 1, 2);
        grid.add(new Label("Enter a Valid A Number:"), 0, 3);
        grid.add(isValidANumberField, 1, 3);
        grid.add(new Label("Enter a Valid Email:"), 0, 4);
        grid.add(isValidEmailField, 1, 4);
        grid.add(new Label("Enter a Valid Date of Birth:"), 0, 5);
        grid.add(isValidDOBField, 1, 5);

        // Submit button
        Button btn = new Button("Submit");
        btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
        grid.add(btn, 1, 6);

        btn.setOnAction(e -> {
            PetitionLogic.PetitionData data = new PetitionLogic.PetitionData();
            data.petitionerName = petitionerNameField.getText();
            data.alienFianceeName = alienFianceeNameField.getText();
            data.alienChildrenNames = alienChildrenNamesField.getText();
            data.isValidDOB = isValidEmailField.getText();
            data.isValidDOB = isValidDOBField.getText();

            try {
                data.isValidANumber = Integer.parseInt(isValidANumberField.getText());
            } catch (NumberFormatException ex) {
                // Handle invalid A-Number input
                // For example, set to a default value or show an error message
                data.isValidANumber = -1; // Example default value indicating invalid input
            }

            boolean isEmailValid = PetitionLogic.isValidEmail(data.isValidEmail);
            boolean isDOBValid = PetitionLogic.isValidDOB(data.isValidDOB);

            PetitionLogic.addPetition(data.petitionerName, data);

            PetitionLogic.PetitionData retrievedData = PetitionLogic.getPetition(data.petitionerName);
            System.out.println("Retrieved Data: " + retrievedData); // For debugging, prints to console

            // Show confirmation alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Submission Successful");
            alert.setHeaderText(null);
            alert.setContentText("You submitted your Form!");
            alert.showAndWait();

            primaryStage.close();
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}