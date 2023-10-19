package unitTests;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.PetitionLogic;
import java.util.List;

class PetitionLogicTest {
    private PetitionLogic petitionLogic;
    @BeforeEach
    void builder(){
        petitionLogic = new PetitionLogic();
    }
    @Test
    void createNewPetition() {
        assertEquals("", petitionLogic.getPetitionerName());
        assertEquals("", petitionLogic.getAlienFianceeName());
        assertEquals("", petitionLogic.getAlienChildrenNames());
        assertFalse(petitionLogic.isAccessGrantedUnderDifferentImmigrant());
        assertFalse(petitionLogic.isPetitionSubmitted());
        assertNull(petitionLogic.getPetitionData());
        assertFalse(petitionLogic.getEligibilityCriteria());
        assertFalse(petitionLogic.isDuplicateCheckResults());
        fail("Default Values Fail on run");
    }

    @Test
    void testGetPetition() {
        // Access private fields using the getter methods
        String petitionerName = petitionLogic.getPetitionerName();
        String alienFianceeName = petitionLogic.getAlienFianceeName();
        String alienChildrenNames = petitionLogic.getAlienChildrenNames();
        boolean accessGrantedUnderDifferentImmigrant = petitionLogic.isAccessGrantedUnderDifferentImmigrant();
        boolean petitionSubmitted = petitionLogic.isPetitionSubmitted();
        Object petitionData = petitionLogic.getPetitionData();
        boolean duplicateCheckResults = petitionLogic.isDuplicateCheckResults();

        // Validate the values
        assertEquals("John Doe", petitionerName);
        assertEquals("Jane Smith", alienFianceeName);
        assertEquals("Child1, Child2", alienChildrenNames);
        assertFalse(accessGrantedUnderDifferentImmigrant);
        assertTrue(petitionSubmitted);
        assertNotNull(petitionData);
        assertFalse(duplicateCheckResults);
    }

    @Test
    void validatePetition() {
        PetitionLogic petition = new PetitionLogic();
        petition.setPetitionerName("John Doe");
        petition.setAlienFianceeName("Jane Smith");
        petition.setAlienChildrenNames("Child1, Child2");
        petition.setAccessGrantedUnderDifferentImmigrant(false);
        petition.setPetitionSubmitted(true);
        petition.setPetitionData(new Object()); // Valid data object
        petition.setEligibilityCriteria(true);
        List<String> validationErrors = petition.validatePetition();
        // Assert that there are no validation errors
        assertNotNull(validationErrors);
        assertTrue(validationErrors.isEmpty());

        // Modify the petition to introduce invalid data types
        petition.setPetitionData("Invalid Data"); // Set data as a string

        // Validate the modified petition
        validationErrors = petition.validatePetition();

        // Assert that there are validation errors for the invalid data type
        assertFalse(validationErrors.isEmpty());

        // Test with other attributes in the petition
        petition.setPetitionerName(String.valueOf(123)); // Introduce an invalid data type (integer) for petitioner name
        petition.setAlienFianceeName(null); // Introduce a null value for alien fiancée
        // Validate the modified petition
        validationErrors = petition.validatePetition();
        // Assert that there are validation errors for the introduced errors
        assertFalse(validationErrors.isEmpty());
        // Test null values for various attributes
        petition.setPetitionerName(null);
        petition.setAlienFianceeName("");
        petition.setAlienChildrenNames(null);
        petition.setPetitionData(null);
        petition.setEligibilityCriteria(false);
        // Validate the modified petition with null values
        validationErrors = petition.validatePetition();
        // Assert that there are validation errors for the null values
        assertFalse(validationErrors.isEmpty());

    }

    @Test
    void isValidANumber() {
        // Valid 8-digit number
        assertTrue(petitionLogic.isValidANumber(12345678));
        // Valid 9-digit number
        assertTrue(petitionLogic.isValidANumber(123456789));
        // Invalid numbers
        assertFalse(petitionLogic.isValidANumber(12345)); // Less than 8 digits
        assertFalse(petitionLogic.isValidANumber(1234567890)); // More than 9 digits
        // Non-integer characters
        assertFalse(petitionLogic.isValidANumber((int) 12.5)); // Non-integer input
        // Null input
        assertFalse(petitionLogic.isValidANumber(null));
        // String input should be considered invalid
        assertFalse(petitionLogic.isValidANumber(Integer.valueOf("invalid_string")));
    }


    @Test
    void isValidEmail() {
        //Email Setup
        EmailValidator emailValidator = EmailValidator.getInstance();
        assertTrue(emailValidator.isValid("user@example.com"));
        assertTrue(emailValidator.isValid("john.doe123@gmail.com"));

        // Invalid Email
        assertFalse(emailValidator.isValid("NOTANEMAIL"));
        assertFalse(emailValidator.isValid("test@.com"));
        assertFalse(emailValidator.isValid("test.email.com"));
        assertFalse(emailValidator.isValid("user@test.c"));

        // Add conditions that are unlikely to pass with a valid email format
        assertFalse(emailValidator.isValid("user@")); // Missing domain
        assertFalse(emailValidator.isValid("user@example")); // Missing top-level domain
        assertFalse(emailValidator.isValid("user@.com")); // Missing domain name
        assertFalse(emailValidator.isValid("user@ .com")); // Space in the domain
        assertFalse(emailValidator.isValid("user@ex ample.com")); // Space in the local part
        assertFalse(emailValidator.isValid(null)); // Null input
        assertFalse(emailValidator.isValid("")); // Empty string
        fail("Since this a validator it will always pass so it can fail here");

    }

    @Test
    void isValidDOB() {
        // Valid DOBs in MM-DD-YYYY format
        assertTrue(PetitionLogic.isValidDOB("01-15-1990"));
        assertTrue(PetitionLogic.isValidDOB("12-31-1985"));
        // Leap year DOB
        assertTrue(PetitionLogic.isValidDOB("02-29-2000"));
        // Invalid DOB formats
        assertFalse(PetitionLogic.isValidDOB("1990-01-15"));
        assertFalse(PetitionLogic.isValidDOB("01/15/1990"));
        assertFalse(PetitionLogic.isValidDOB("01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-1990-01"));
        // Future DOBs
        assertFalse(PetitionLogic.isValidDOB("05-10-2050"));
        assertFalse(PetitionLogic.isValidDOB("12-31-3000"));
        // Invalid month/day
        assertFalse(PetitionLogic.isValidDOB("02-30-1990"));
        assertFalse(PetitionLogic.isValidDOB("04-31-1990"));
        //Invalid Types
        assertFalse(PetitionLogic.isValidDOB("TESTING"));
        assertFalse(PetitionLogic.isValidDOB("3.14"));
        assertFalse(PetitionLogic.isValidDOB(new Object().toString()));
    }

    @Test
    void checkForDuplicates() {
        PetitionLogic petition = new PetitionLogic();
        petition.setPetitionerName("John Doe");
        petition.setAlienFianceeName("Jane Smith");
        petition.setAlienChildrenNames("Child1, Child2");
        petition.setAccessGrantedUnderDifferentImmigrant(false);
        petition.setPetitionSubmitted(true);
        petition.setPetitionData(new Object()); // Valid data object
        petition.setEligibilityCriteria(true);
        // Assuming you have a system to check for duplicates, simulate a check
        boolean isDuplicate = petition.checkForDuplicates();
        // Assert that the system correctly identifies the petition as a duplicate
        assertTrue(isDuplicate);
        // You can also test cases where there are no duplicates
        PetitionLogic newPetition = new PetitionLogic(); // Create a new petition with different data
        newPetition.setPetitionerName("Alice Smith");
        newPetition.setAlienFianceeName("Bob Johnson");
        newPetition.setAlienChildrenNames("Child3, Child4");
        newPetition.setAccessGrantedUnderDifferentImmigrant(true); // Different value
        newPetition.setPetitionSubmitted(false); // Different value
        newPetition.setPetitionData(new Object()); // Valid data object
        newPetition.setEligibilityCriteria(true);
        // Simulate a check for duplicates for the new petition
        boolean isNewPetitionDuplicate = newPetition.checkForDuplicates();
        // Assert that the system correctly identifies the new petition as not a duplicate
        assertFalse(isNewPetitionDuplicate);
    }
}