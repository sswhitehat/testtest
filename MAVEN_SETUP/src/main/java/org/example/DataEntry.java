package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataEntry {

    // Constructor
    public DataEntry() {
        // Initialization if needed
    }

    // Method to receive data from DataEntryScreen
    public void receiveData(String petitionerName, String alienFianceeName, String alienChildrenNames,
                            String aNumber, String email, String dob) {
        // Validate the data
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!isValidDOB(dob)) {
            throw new IllegalArgumentException("Invalid date of birth format");
        }

        int validANumber;
        boolean isValidANumberFlag;
        try {
            validANumber = Integer.parseInt(aNumber);
            // Assuming any positive integer is a valid A Number
            isValidANumberFlag = validANumber > 0;
        } catch (NumberFormatException e) {
            validANumber = 0; // or any default invalid value
            isValidANumberFlag = false;
        }

        // Create PetitionData object
        PetitionLogic.PetitionData petitionData = new PetitionLogic.PetitionData(
                petitionerName,
                alienFianceeName,
                alienChildrenNames,
                validANumber, // Pass the integer value
                isValidANumberFlag, // Pass the boolean flag for A Number validity
                isValidEmail(email), // Pass the result of validation
                isValidDOB(dob) // Pass the result of validation
        );

        // Pass data to PetitionDataStorage
        PetitionDataStorage.storePetitionData(petitionData);
    }

    // Reuse validation methods from PetitionLogic
    private static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    private static boolean isValidDOB(String dob) {
        try {
            LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}