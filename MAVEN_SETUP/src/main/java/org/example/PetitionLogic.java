package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class PetitionLogic {

    private String petitionerName;
    private String alienFianceeName;
    private String alienChildrenNames;
    private int aNumber; // A-Number as an integer
    private String email;
    private String dob; // Date of Birth as String

    // Parameterized Constructor
    public PetitionLogic(String petitionerName, String alienFianceeName, String alienChildrenNames,
                         int aNumber, String email, String dob) {
        this.petitionerName = petitionerName;
        this.alienFianceeName = alienFianceeName;
        this.alienChildrenNames = alienChildrenNames;
        this.aNumber = aNumber;
        this.email = email;
        this.dob = dob;
    }

    // Method to validate the petition data
    public List<String> validatePetition() {
        List<String> errors = new ArrayList<>();

        if (!isValidANumber(this.aNumber)) {
            errors.add("Invalid A-Number");
        }
        if (!isValidEmail(this.email)) {
            errors.add("Invalid Email");
        }
        if (!isValidDOB(this.dob)) {
            errors.add("Invalid Date of Birth");
        }

        return errors;
    }

    // Static utility methods
    public static boolean isValidANumber(int aNumber) {
        // Assuming A-Number should be 8 or 9 digits long
        return Integer.toString(aNumber).length() == 8 || Integer.toString(aNumber).length() == 9;
    }

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
        boolean isValidANumberFlag = isValidANumber(this.aNumber);
        boolean isValidEmailFlag = isValidEmail(this.email);
        boolean isValidDOBFlag = isValidDOB(this.dob);
        return new PetitionData(
                petitionerName,
                alienFianceeName,
                alienChildrenNames,
                aNumber,
                isValidANumber(aNumber),
                isValidEmail(email),
                isValidDOB(dob),
                email, // Pass the email
                dob   // Pass the dob
        );
    }

    // Nested class for PetitionData
    public static class PetitionData {
        private String petitionerName;
        private String alienFianceeName;
        private String alienChildrenNames;
        private int aNumber; // A-Number as an integer
        private boolean isValidANumber;
        private boolean isValidEmail;
        private boolean isValidDOB;
        private String email; // Email as String
        private String dob; // Date of Birth as String

        // Constructor
        public PetitionData(String petitionerName, String alienFianceeName, String alienChildrenNames,
                            int aNumber, boolean isValidANumber, boolean isValidEmail, boolean isValidDOB, String email, String dob) {
            this.petitionerName = petitionerName;
            this.alienFianceeName = alienFianceeName;
            this.alienChildrenNames = alienChildrenNames;
            this.aNumber = aNumber;
            this.isValidANumber = isValidANumber;
            this.isValidEmail = isValidEmail;
            this.isValidDOB = isValidDOB;
            this.email = email;  // Use the passed parameter
            this.dob = dob;
        }

        // Getters
        public String getPetitionerName() {
            return petitionerName;
        }

        public String getAlienFianceeName() {
            return alienFianceeName;
        }

        public String getAlienChildrenNames() {
            return alienChildrenNames;
        }

        public int getANumber() {
            return aNumber;
        }

        public boolean getIsValidANumber() {
            return isValidANumber;
        }

        public boolean getIsValidEmail() {
            return isValidEmail;
        }

        public boolean getIsValidDOB() {
            return isValidDOB;
        }

        // Added getters for email and dob
        public String getEmail() {
            return email;
        }

        public String getDOB() {
            return dob;
        }
    }
    }