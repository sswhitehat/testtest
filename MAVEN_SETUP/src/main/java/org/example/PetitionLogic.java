package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PetitionLogic {

    // Constructor
    public PetitionLogic() {
        // Initialization if needed
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

    // Other business logic methods as needed

    // Nested class for PetitionData (if still needed)
    public static class PetitionData {
        String petitionerName;
        String alienFianceeName;
        String alienChildrenNames;
        int isValidANumber;
        String isValidEmail;
        String isValidDOB;

        // toString method and other methods as needed
    }
}