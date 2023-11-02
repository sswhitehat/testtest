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
        try {
            validANumber = Integer.parseInt(aNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("A Number must be a valid integer");
        }

        // Create PetitionData object
        PetitionLogic.PetitionData petitionData = new PetitionLogic.PetitionData();
        petitionData.petitionerName = petitionerName;
        petitionData.alienFianceeName = alienFianceeName;
        petitionData.alienChildrenNames = alienChildrenNames;
        petitionData.isValidANumber = validANumber;
        petitionData.isValidEmail = email;
        petitionData.isValidDOB = dob;

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