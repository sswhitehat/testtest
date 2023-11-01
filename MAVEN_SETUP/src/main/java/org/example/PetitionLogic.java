package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class PetitionLogic {


    private String petitionerName;

    private static final Map<String, PetitionData> STRING_PETITION_DATA_HASH_MAP = new HashMap<>();

    private String alienFianceeName;
    private String alienChildrenNames;
    private boolean accessGrantedUnderDifferentImmigrant;
    private boolean petitionSubmitted;
    private Object petitionData;
    private boolean duplicateCheckResults;


    private PetitionLogic(
            String petitionerName,
            String alienFianceeName,
            String alienChildrenNames,
            boolean accessGrantedUnderDifferentImmigrant,
            boolean petitionSubmitted,
            Object petitionData,
            boolean duplicateCheckResults) {
        this.petitionerName = petitionerName;
        this.alienFianceeName = alienFianceeName;
        this.alienChildrenNames = alienChildrenNames;
        this.accessGrantedUnderDifferentImmigrant = accessGrantedUnderDifferentImmigrant;
        this.petitionSubmitted = petitionSubmitted;
        this.petitionData = petitionData;
        this.duplicateCheckResults = duplicateCheckResults;

    }

    public void setPetitionerName(String petitionerName) {
        this.petitionerName = petitionerName;
    }

    public void setAlienFianceeName(String alienFianceeName) {
        this.alienFianceeName = alienFianceeName;
    }

    public void setAlienChildrenNames(String alienChildrenNames) {
        this.alienChildrenNames = alienChildrenNames;
    }

    public void setAccessGrantedUnderDifferentImmigrant(boolean accessGrantedUnderDifferentImmigrant) {
        this.accessGrantedUnderDifferentImmigrant = accessGrantedUnderDifferentImmigrant;
    }

    public void setPetitionSubmitted(boolean petitionSubmitted) {
        this.petitionSubmitted = petitionSubmitted;
    }

    public void setPetitionData(Object petitionData) {
        this.petitionData = petitionData;
    }


    public void setDuplicateCheckResults(boolean duplicateCheckResults) {
        this.duplicateCheckResults = duplicateCheckResults;
    }

    public String getPetitionerName() {
        return petitionerName;
    }

    public String getAlienFianceeName() {
        return alienFianceeName;
    }

    public String getAlienChildrenNames() {
        return alienChildrenNames;
    }

    public boolean isAccessGrantedUnderDifferentImmigrant() {
        return accessGrantedUnderDifferentImmigrant;
    }

    public boolean isPetitionSubmitted() {
        return petitionSubmitted;
    }

    public Object getPetitionData() {
        return petitionData;
    }

    public boolean isDuplicateCheckResults() {
        return duplicateCheckResults;
    }


    public PetitionLogic getPetition() {

        return null;
    }

    public List<String> validatePetition() {

        return null;
    }

    public boolean isValidANumber(Integer aNumber) {

        return false;
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isValidDOB(String DateofBirth) {

        try {
            LocalDate.parse(DateofBirth, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean checkForDuplicates() {

        return false;
    }

    public static void addPetition(String key, PetitionData data) {
        STRING_PETITION_DATA_HASH_MAP.put(key, data);
    }

    public static PetitionData getPetition(String key) {
        return STRING_PETITION_DATA_HASH_MAP.get(key);
    }
    // Other getters and setters for attributes if needed


    public Object createNewPetition() {
        return null;
    }


    static class PetitionData {
        String petitionerName;
        String alienFianceeName;
        String alienChildrenNames;
        int isValidANumber;
        String isValidEmail;
        String isValidDOB;

        public String toString() {
            return "PetitionData{" +
                    "petitionerName='" + petitionerName + '\'' +
                    ", alienFianceeName='" + alienFianceeName + '\'' +
                    ", alienChildrenNames='" + alienChildrenNames + '\'' +
                    ", isValidANumber=" + isValidANumber +
                    ", isValidEmail=" + isValidEmail +
                    ", isValidDOB=" + isValidDOB +
                    // ... other fields ...
                    '}';
        }
    }
}