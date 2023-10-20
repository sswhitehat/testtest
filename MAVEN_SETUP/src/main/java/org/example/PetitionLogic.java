package org.example;
import java.util.List;

public class PetitionLogic {


    private String petitionerName;
    private String alienFianceeName;
    private String alienChildrenNames;
    private boolean accessGrantedUnderDifferentImmigrant;
    private boolean petitionSubmitted;
    private Object petitionData;
    private boolean eligibilityCriteria;
    private boolean duplicateCheckResults;

    private PetitionLogic(
            String petitionerName,
            String alienFianceeName,
            String alienChildrenNames,
            boolean accessGrantedUnderDifferentImmigrant,
            boolean petitionSubmitted,
            Object petitionData,
            boolean eligibilityCriteria,
            boolean duplicateCheckResults) {
            this.petitionerName = petitionerName;
            this.alienFianceeName = alienFianceeName;
            this.alienChildrenNames = alienChildrenNames;
            this.accessGrantedUnderDifferentImmigrant = accessGrantedUnderDifferentImmigrant;
            this.petitionSubmitted = petitionSubmitted;
            this.petitionData = petitionData;
            this.eligibilityCriteria = eligibilityCriteria;
            this.duplicateCheckResults = duplicateCheckResults;
      
    }
    
    public PetitionLogic() {
        this.petitionerName = "";
        this.alienFianceeName = "";
        this.alienChildrenNames = "";
        this.accessGrantedUnderDifferentImmigrant = false;
        this.petitionSubmitted = false;
        this.petitionData = null;
        this.eligibilityCriteria = false;
        this.duplicateCheckResults = false;
    }
    
    public PetitionLogic(
            String petitionerName,
            String alienFianceeName,
            String alienChildrenNames,
            Object petitionData,
            boolean eligibilityCriteria) {
        
        this.petitionerName = petitionerName;
        this.alienFianceeName = alienFianceeName;
        this.alienChildrenNames = alienChildrenNames;
        this.accessGrantedUnderDifferentImmigrant = false;
        this.petitionSubmitted = false;
        this.petitionData = petitionData;
        this.eligibilityCriteria = false;
        this.duplicateCheckResults = false;
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

    public void setEligibilityCriteria(boolean eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
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

    public boolean getEligibilityCriteria() {
        return eligibilityCriteria;
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

    public boolean isValidANumber(Integer ANumber) {
        
        return false; 
    }

    public boolean isValidEmail(String email) {
      
        return false; 
    }

    public static boolean isValidDOB(String DateofBirth) {
   
        return false; 
    }

    public boolean checkForDuplicates() {

        return false;
    }

    // Other getters and setters for attributes if needed

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    public Object createNewPetition() {
        return null;
    }
}