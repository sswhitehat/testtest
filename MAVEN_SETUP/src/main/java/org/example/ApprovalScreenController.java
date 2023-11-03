package org.example;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class ApprovalScreenController {

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
    void approveClick(ActionEvent event) {
        // Approval logic here
        showInformationAlert("Approved", "Application approved", "Congratulations! Your application has been approved!");
    }

    @FXML
    void rejectClick(ActionEvent event) {
        // Rejection logic here
        showErrorAlert("Denied", "Application denied", "There was an error in your application.");
    }

    private void showInformationAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void showErrorAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}