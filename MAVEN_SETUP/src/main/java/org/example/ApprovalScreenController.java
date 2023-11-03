package com.example;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ApprovalScreenController {

    private User selectedUser;

    @FXML
    private Button approve;

    @FXML
    private Button reject;

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

    public void initData(User user){
        selectedUser = user;
        labelID.setText(Integer.toString(selectedUser.getID()));
        labelName.setText(selectedUser.getName());
        labelDOB.setText(selectedUser.getDOB());
        labelF_name.setText(selectedUser.getf_name());
        labelC_name.setText(selectedUser.getc_name());
    }

    @FXML
    void approveClick(ActionEvent event) {
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Approved");
        successAlert.setHeaderText("Application approved");
        successAlert.setContentText("Congratulation! Your application has been approved!");
        successAlert.showAndWait();
    }

    @FXML
    void rejectClick(ActionEvent event) {
        Alert failureAlert = new Alert(Alert.AlertType.ERROR);
        failureAlert.setTitle("Denied");
        failureAlert.setHeaderText("Application denied");
        failureAlert.setContentText("There was an error in your application");
        failureAlert.showAndWait();
    }


    /* 
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        id.setText("HHJ");

    }*/

}
