package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PetitionLogic {

    private String petitionerName;
    private String alienFianceeName;
    private String alienChildrenNames;
    private int isValidANumber;
    private Boolean isValidEmail;
    private Boolean isValidDOB;

    // Default Constructor
    public PetitionLogic() {
        this("", "", "", 0, false, false);
    }

    // Parameterized Constructor
    public PetitionLogic(String petitionerName, String alienFianceeName, String alienChildrenNames,
                         int isValidANumber, Boolean isValidEmail, Boolean isValidDOB) {
        this.petitionerName = petitionerName;
        this.alienFianceeName = alienFianceeName;
        this.alienChildrenNames = alienChildrenNames;
        this.isValidANumber = isValidANumber;
        this.isValidEmail = isValidEmail;
        this.isValidDOB = isValidDOB;
    }

    // Method to validate the petition data
    public List<String> validatePetition(PetitionData petitionData) {
        // Implement validation logic here
        // Return a list of validation errors or an empty list if valid
        return null;
    }

    // Method to check for duplicates
    public boolean checkForDuplicates(String petitionerName) {
        return PetitionDataStorage.isDuplicatePetition(petitionerName);
    }

    // Static utility methods
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidDOB(String dob) {
        try {
            LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Method to convert to PetitionData
    public PetitionData toPetitionData() {
        // Assuming isValidANumber > 0 means the A Number is valid
        boolean isValidANumberFlag = Integer.toString(isValidANumber).length() == 8 || Integer.toString(isValidANumber).length() == 9;
        return new PetitionData(petitionerName, alienFianceeName, alienChildrenNames, isValidANumber, isValidANumberFlag, isValidEmail, isValidDOB);
    }

    // Nested class for PetitionData
    public static class PetitionData {
        String petitionerName;
        String alienFianceeName;
        String alienChildrenNames;
        int aNumber; // Actual A Number
        boolean isValidANumber; // Flag for A Number validity
        boolean isValidEmail;
        boolean isValidDOB;

        public PetitionData(String petitionerName, String alienFianceeName, String alienChildrenNames,
                            int aNumber, boolean isValidANumber, boolean isValidEmail, boolean isValidDOB) {
            this.petitionerName = petitionerName;
            this.alienFianceeName = alienFianceeName;
            this.alienChildrenNames = alienChildrenNames;
            this.aNumber = aNumber;
            this.isValidANumber = isValidANumber;
            this.isValidEmail = isValidEmail;
            this.isValidDOB = isValidDOB;
        }
    }
}