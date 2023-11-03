package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ReviewScreenController {

    @FXML
    private Label labelC_name;

    @FXML
    private Label labelDOB;

    @FXML
    private Label labelF_name;

    @FXML
    private Label labelID;

    @FXML
    private Label labelName;

    @FXML
    private Button sendInfo;

    @FXML
    void sendInfotoApproval(MouseEvent event) {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Data transport");
        successAlert.setHeaderText("Success");
        successAlert.setContentText("The information is sent to approval.");
        successAlert.showAndWait();
    }

}

