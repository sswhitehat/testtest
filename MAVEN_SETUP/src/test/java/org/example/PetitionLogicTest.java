package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// import src.PetitionLogic;
import java.util.List;

class PetitionLogicTest {
    private PetitionLogic petitionLogic;

    @BeforeEach
    //BUILDER FOR A PETITION BEFORE EACH TESTS - JUNIT 5 SUGGESTION
    void builder(){
        petitionLogic = new PetitionLogic();
    }
    @Test
    void createNewPetition() {
        //BASIC CHECKS FOR EXPECTED VALUES COMPLETED BY GENERATE IN INTELLIJ
        assertEquals("", petitionLogic.getPetitionerName());
        assertEquals("", petitionLogic.getAlienFianceeName());
        assertEquals("", petitionLogic.getAlienChildrenNames());
        assertFalse(petitionLogic.isAccessGrantedUnderDifferentImmigrant());
        assertFalse(petitionLogic.isPetitionSubmitted());
        assertNull(petitionLogic.getPetitionData());
        assertFalse(petitionLogic.getEligibilityCriteria());
        assertFalse(petitionLogic.isDuplicateCheckResults());
        fail("TEST FAIL FOR DEFAULT");
    }

    @Test
    void testGetPetition() {
        // ACCESSING FIELDS TO CHECK MOCK VALUES
        String petitionerName = petitionLogic.getPetitionerName();
        String alienFianceeName = petitionLogic.getAlienFianceeName();
        String alienChildrenNames = petitionLogic.getAlienChildrenNames();
        boolean accessGrantedUnderDifferentImmigrant = petitionLogic.isAccessGrantedUnderDifferentImmigrant();
        boolean petitionSubmitted = petitionLogic.isPetitionSubmitted();
        Object petitionData = petitionLogic.getPetitionData();
        boolean duplicateCheckResults = petitionLogic.isDuplicateCheckResults();
        // CHECKING SAID VALUES
        assertEquals("John Smith", petitionerName);
        assertEquals("Jane Smith", alienFianceeName);
        assertEquals("Child", alienChildrenNames);
        assertFalse(accessGrantedUnderDifferentImmigrant);
        assertTrue(petitionSubmitted);
        assertNotNull(petitionData);
        assertFalse(duplicateCheckResults);
    }

    @Test
    void validatePetition() {
        //VALIDATING A CREATED PETITION - GENERATED TESTS FROM INTELLIJ
        PetitionLogic petition = new PetitionLogic();
        petition.setPetitionerName("John Smith");
        petition.setAlienFianceeName("Jane Smith");
        petition.setAlienChildrenNames("Child");
        petition.setAccessGrantedUnderDifferentImmigrant(false);
        petition.setPetitionSubmitted(true);
        petition.setPetitionData(new Object());
        petition.setEligibilityCriteria(true);
        List<String> validationErrors = petition.validatePetition();
        //CHECK IF IT IS EMPTY AND VALIDATE
        assertNotNull(validationErrors);
        assertTrue(validationErrors.isEmpty());
        petition.setPetitionData("Invalid Data");
        validationErrors = petition.validatePetition();
        // USE WRONG VALUES AND TEST VALIDATE
        petition.setPetitionerName(String.valueOf(123));
        petition.setAlienFianceeName(null);
        validationErrors = petition.validatePetition();
        assertFalse(validationErrors.isEmpty());
        // NULL VALUES AND TEST METHOD
        petition.setPetitionerName(null);
        petition.setAlienFianceeName("");
        petition.setAlienChildrenNames(null);
        petition.setPetitionData(null);
        petition.setEligibilityCriteria(false);
        validationErrors = petition.validatePetition();
        assertFalse(validationErrors.isEmpty());

    }

    @Test
    void isValidANumber() {
        // VALID 8 - MADE BY ME - SEAN BASED ON A NUMBER DETAILS ONLINE
        assertTrue(petitionLogic.isValidANumber(12345678));
        // VALID 9
        assertTrue(petitionLogic.isValidANumber(123456789));
        // INVALID < or >
        assertFalse(petitionLogic.isValidANumber(12345)); // Less than 8 digits
        assertFalse(petitionLogic.isValidANumber(1234567890)); // More than 9 digits
        // NON INTEGER
        assertFalse(petitionLogic.isValidANumber((int) 17.5)); // Non-integer input
        // NULL CHECK
        assertFalse(petitionLogic.isValidANumber(null));
        // STRING CHECK
        assertFalse(petitionLogic.isValidANumber(Integer.valueOf("invalid_string")));
    }


    @Test
    void isValidEmail() {
        //CALLING EMAIL VALIDATOR FROM MAVEN BASED ON INTELLIJ RECOMMENDATION
    EmailValidator emailValidator = EmailValidator.getInstance();
    //VALID EMAIL
    assertTrue(emailValidator.isValid("user@example.com"));
    assertTrue(emailValidator.isValid("john.doe123@gmail.com"));
    // INVALID EMAIL
    assertFalse(emailValidator.isValid("NOTANEMAIL"));
    assertFalse(emailValidator.isValid("test@.com"));
    assertFalse(emailValidator.isValid("test.email.com"));
    assertFalse(emailValidator.isValid("user@test.c"));
    // FORMATS THAT ARE NOT ACCEPTED - APACHE RULES FOR EMAIL ADDRESSES
    assertFalse(emailValidator.isValid("user@"));
    assertFalse(emailValidator.isValid("user@example"));
    assertFalse(emailValidator.isValid("user@.com"));
    assertFalse(emailValidator.isValid("user@ .com"));
    assertFalse(emailValidator.isValid("user@ex ample.com"));
    assertFalse(emailValidator.isValid(null));
    assertFalse(emailValidator.isValid(""));
    //VALIDATOR FAIL CONDITION SINCE IT CANNOT BE A RED TEST DUE TO NATURE OF VALIDATOR TESTING
    fail("Since this a validator it will always pass so it can fail here");

    }

    @Test
    void isValidDOB() {
        // VALID DOB
        assertTrue(PetitionLogic.isValidDOB("01-15-1990"));
        assertTrue(PetitionLogic.isValidDOB("12-31-1985"));
        // LEAP DOB
        assertTrue(PetitionLogic.isValidDOB("02-29-2000"));
        // INVALID DOB
        assertFalse(PetitionLogic.isValidDOB("1990-01-15"));
        assertFalse(PetitionLogic.isValidDOB("01/15/1990"));
        assertFalse(PetitionLogic.isValidDOB("01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-1990-01"));
        // NON EXISTENT DAYS
        assertFalse(PetitionLogic.isValidDOB("02-30-1990"));
        assertFalse(PetitionLogic.isValidDOB("04-31-1990"));
        //WRONG TYPE
        assertFalse(PetitionLogic.isValidDOB("TESTING"));
        assertFalse(PetitionLogic.isValidDOB("3.14"));
        assertFalse(PetitionLogic.isValidDOB(new Object().toString()));
    }

    @Test
    void checkForDuplicates() {
        //NEW PETITION OBJECT TO TEST DUPLICATE - INTELLIJ GENERATED TESTS
        PetitionLogic petition = new PetitionLogic();
        petition.setPetitionerName("John Smith");
        petition.setAlienFianceeName("Jane Smith");
        petition.setAlienChildrenNames("Child");
        petition.setAccessGrantedUnderDifferentImmigrant(false);
        petition.setPetitionSubmitted(true);
        petition.setPetitionData(new Object());
        petition.setEligibilityCriteria(true);
        // CHECK USING A BOOL LATER THAT I WILL IMPLEMENT FROM EITHER DB OR ARRAY OR WHATEVER STRUCT WE CHOOSE TO HOLD DATA
        boolean isDuplicate = petition.checkForDuplicates();
        // TRUE BECAUSE THE SYSTEM SHOULD IDENTIFY IF ALREADY IN SYSTEM
        assertTrue(isDuplicate);
        // CHECK NOT DUPLICATE - INTELLIJ GENERATED TESTS
        PetitionLogic newPetition = new PetitionLogic();
        newPetition.setPetitionerName("Gary Smith");
        newPetition.setAlienFianceeName("Jill Smith");
        newPetition.setAlienChildrenNames("Child1");
        newPetition.setAccessGrantedUnderDifferentImmigrant(true);
        newPetition.setPetitionSubmitted(false);
        newPetition.setPetitionData(new Object());
        newPetition.setEligibilityCriteria(true);
        // SAME AS ABOVE BUT THE OTHER WAY AROUND
        boolean isNewPetitionDuplicate = newPetition.checkForDuplicates();
        // FALSE SINCE NOT A DUPE
        assertFalse(isNewPetitionDuplicate);
    }
}