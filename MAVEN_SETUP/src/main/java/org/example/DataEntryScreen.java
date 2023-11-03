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

        //Header
        Label headerLabel = new Label("Petition for Alien Fiancé(e) and Children");
        headerLabel.setStyle("-fx-font-size: 20px; -fx-underline: true;");
        grid.add(headerLabel, 0, 0, 4, 1); // Updated to span 4 columns
        GridPane.setMargin(headerLabel, new Insets(0, 0, 30, 0));

        // Text fields with direct styling
        TextField petitionerNameField = new TextField();
        petitionerNameField.setPrefWidth(300);
        petitionerNameField.setStyle("-fx-padding: 5;");

        TextField alienFianceeNameField = new TextField();
        alienFianceeNameField.setPrefWidth(300);
        alienFianceeNameField.setStyle("-fx-padding: 5;");

        TextField alienChildrenNamesField = new TextField();
        alienChildrenNamesField.setPrefWidth(300);
        alienChildrenNamesField.setStyle("-fx-padding: 5;");

        TextField isValidANumberField = new TextField();
        isValidANumberField.setPrefWidth(300);
        isValidANumberField.setStyle("-fx-padding: 5;");

        TextField isValidEmailField = new TextField();
        isValidEmailField.setPrefWidth(300);
        isValidEmailField.setStyle("-fx-padding: 5;");

        TextField isValidDOBField = new TextField();
        isValidDOBField.setPrefWidth(300);
        isValidDOBField.setStyle("-fx-padding: 5;");


        // Add components to grid
        grid.add(new Label("Enter your Name:"), 0, 1);
        grid.add(petitionerNameField, 1, 1, 3, 1);  // Span 3 columns
        grid.add(new Label("Enter your Fiancee's Name:"), 0, 2);
        grid.add(alienFianceeNameField, 1, 2, 3, 1);
        grid.add(new Label("Enter your children's name(s):"), 0, 3);
        grid.add(alienChildrenNamesField, 1, 3, 3, 1);
        grid.add(new Label("Enter a Valid A Number:"), 0, 4);
        grid.add(isValidANumberField, 1, 4, 3, 1);
        grid.add(new Label("Enter a Valid Email:"), 0, 5);
        grid.add(isValidEmailField, 1, 5, 3, 1);
        grid.add(new Label("Enter a Valid Date of Birth:"), 0, 6);
        grid.add(isValidDOBField, 1, 6, 3, 1);
        // Submit button
        Button btn = new Button("Submit");
        btn.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-padding: 10 20; -fx-font-size: 14px;");
        grid.add(btn, 2, 7);

        btn.setOnAction(e -> {
            // Create an instance of DataEntry
            DataEntry dataEntry = new DataEntry();

            try {
                // Pass data to DataEntry for processing
                dataEntry.receiveData(
                        petitionerNameField.getText(),
                        alienFianceeNameField.getText(),
                        alienChildrenNamesField.getText(),
                        isValidANumberField.getText(),
                        isValidEmailField.getText(),
                        isValidDOBField.getText()
                );

                // Check if data is stored correctly
                PetitionLogic.PetitionData storedData = PetitionDataStorage.getPetitionData(petitionerNameField.getText());
                if (storedData != null && storedData.petitionerName.equals(petitionerNameField.getText())) {
                    // Data stored successfully
                    System.out.println("Data stored in hashmap: " + storedData);  // Print the stored data

                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Submission Successful");
                    successAlert.setHeaderText(null);
                    successAlert.setContentText("Your form has been submitted and stored successfully!");
                    successAlert.showAndWait();
                } else {
                    // Data not stored correctly
                    Alert failureAlert = new Alert(Alert.AlertType.ERROR);
                    failureAlert.setTitle("Submission Error");
                    failureAlert.setHeaderText("Storage Error");
                    failureAlert.setContentText("There was an error storing your form. Please try again.");
                    failureAlert.showAndWait();
                }

            } catch (IllegalArgumentException ex) {
                // Show error alert
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Validation Error");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 600, 450);  // Adjusted dimensions
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}