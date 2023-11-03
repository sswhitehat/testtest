package org.example;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.Iterator;
import java.util.Map;

public class ReviewScreenController {
    @FXML private Label labelID;
    @FXML private Label labelName;
    @FXML private Label labelF_name;
    @FXML private Label labelC_name;

    @FXML private Label labelDOB;
    @FXML private Label labelImmigrantNumber;
    @FXML private Label labelEmail;

    @FXML private Button nextButton;

    @FXML private Button sendToApprovalButton;

    @FXML
    private CheckBox isValidEmailCheckbox;
    @FXML
    private CheckBox isValidDOBCheckbox;
    @FXML
    private CheckBox isValidANumberCheckbox;
    @FXML
    private CheckBox isDuplicatePetitionCheckbox;

    private Iterator<Map.Entry<String, PetitionLogic.PetitionData>> petitionIterator;
    private Map.Entry<String, PetitionLogic.PetitionData> currentPetitionEntry;

    @FXML
    public void initialize() {
        // Initialize the iterator
        petitionIterator = PetitionDataStorage.getAllPetitions().entrySet().iterator();
        loadNextPetition();
    }

    @FXML
    public void nextPetition() {
        loadNextPetition();
    }

    private void loadNextPetition() {
        if (petitionIterator.hasNext()) {
            currentPetitionEntry = petitionIterator.next();
            PetitionLogic.PetitionData petitionData = currentPetitionEntry.getValue();
            // Update labels with petition data
            labelName.setText(petitionData.getPetitionerName());
            labelF_name.setText(petitionData.getAlienFianceeName());
            labelC_name.setText(petitionData.getAlienChildrenNames());
            labelImmigrantNumber.setText(String.valueOf(petitionData.getANumber())); // Assuming getANumber() returns a String
            labelEmail.setText(petitionData.getEmail()); // You need to implement getEmail() in PetitionData
            labelDOB.setText(petitionData.getDOB()); // You need to implement getDOB() in PetitionData
        } else {
            // Reset the iterator and disable the next button if there are no more petitions
            petitionIterator = PetitionDataStorage.getAllPetitions().entrySet().iterator();
            nextButton.setDisable(true);
        }
    }

    @FXML
    void sendInfotoApproval(MouseEvent event) {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Data transport");
        successAlert.setHeaderText("Success");
        successAlert.setContentText("The information is sent to approval.");
        successAlert.showAndWait();
    }
}