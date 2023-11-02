package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PetitionLogic {
    
    String petitionerName;
    String alienFianceeName;
    String alienChildrenNames;
    Boolean isValidANumber;
    Boolean isValidEmail;
    Boolean isValidDOB;

    // Constructor
    public PetitionLogic() {
        this.petitionerName = "";
        this.alienFianceeName = "";
        this.alienChildrenNames = "";
        this.isValidANumber = false;
        this.isValidEmail = false;
        this.isValidDOB = false;
    }
    
    // Constructor
    public PetitionLogic(String petitionerName,
    String alienFianceeName,
    String alienChildrenNames,
    Boolean isValidANumber,
    Boolean isValidEmail,
    Boolean isValidDOB) {
        
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

    // Other business logic methods as needed

    // // Nested class for PetitionData (if still needed)
    // public static class PetitionData {
    //     String petitionerName;
    //     String alienFianceeName;
    //     String alienChildrenNames;
    //     int isValidANumber;
    //     String isValidEmail;
    //     String isValidDOB;

    //     // toString method and other methods as needed
    // }
}