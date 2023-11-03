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
        // Validate the data and set flags
        boolean isValidEmailFlag = isValidEmail(email);
        if (!isValidEmailFlag) {
            throw new IllegalArgumentException("Invalid email format");
        }

        boolean isValidDOBFlag = isValidDOB(dob);
        if (!isValidDOBFlag) {
            throw new IllegalArgumentException("Invalid date of birth format");
        }

        int validANumber = 0;
        boolean isValidANumberFlag = false;
        try {
            validANumber = Integer.parseInt(aNumber);
            // Assuming any positive integer is a valid A Number
            isValidANumberFlag = validANumber > 0;
        } catch (NumberFormatException e) {
            // If parsing fails, validANumber remains 0 and isValidANumberFlag remains false
        }

        // Create PetitionData object with the validated data and flags
        PetitionLogic.PetitionData petitionData = new PetitionLogic.PetitionData(
                petitionerName,
                alienFianceeName,
                alienChildrenNames,
                validANumber,
                isValidANumberFlag,
                isValidEmailFlag,
                isValidDOBFlag,
                email, dob);

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