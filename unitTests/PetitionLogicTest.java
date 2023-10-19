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
    void setUp() {
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
        fail("This test should fail until the code is written.");
    }

    @Test
    void testGetPetition() {
        petitionLogic.createNewPetition();
        assertEquals("John Doe", petitionLogic.getPetitionerName());
        // Add similar expectations for other attributes
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
        assertNotNull(validationErrors);
        assertTrue(validationErrors.isEmpty());

        petition.setPetitionData("Invalid Data");
        validationErrors = petition.validatePetition();
        assertFalse(validationErrors.isEmpty());

        petition.setPetitionerName(String.valueOf(123));
        petition.setAlienFianceeName(null);
        validationErrors = petition.validatePetition();
        assertFalse(validationErrors.isEmpty());

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
        assertTrue(petitionLogic.isValidANumber(12345678));
        assertTrue(petitionLogic.isValidANumber(123456789));
        assertFalse(petitionLogic.isValidANumber(12345));
        assertFalse(petitionLogic.isValidANumber(1234567890));
        assertFalse(petitionLogic.isValidANumber((int) 12.5));
        assertFalse(petitionLogic.isValidANumber(null));
        assertFalse(petitionLogic.isValidANumber(Integer.valueOf("invalid_string")));
    }

    @Test
    void isValidEmail() {
        EmailValidator emailValidator = EmailValidator.getInstance();
        assertTrue(emailValidator.isValid("user@example.com"));
        assertTrue(emailValidator.isValid("john.doe123@gmail.com"));
        assertFalse(emailValidator.isValid("NOTANEMAIL"));
        assertFalse(emailValidator.isValid("test@.com"));
        assertFalse(emailValidator.isValid("test.email.com"));
        assertFalse(emailValidator.isValid("user@test.c"));
        assertFalse(emailValidator.isValid("user@"));
        assertFalse(emailValidator.isValid("user@example"));
        assertFalse(emailValidator.isValid("user@.com"));
        assertFalse(emailValidator.isValid("user@ .com"));
        assertFalse(emailValidator.isValid("user@ex ample.com"));
        assertFalse(emailValidator.isValid(null));
        assertFalse(emailValidator.isValid(""));
        fail("Since this is a validator, it will always pass, so it can fail here");
    }

    @Test
    void isValidDOB() {
        assertTrue(PetitionLogic.isValidDOB("01-15-1990"));
        assertTrue(PetitionLogic.isValidDOB("12-31-1985"));
        assertTrue(PetitionLogic.isValidDOB("02-29-2000"));
        assertFalse(PetitionLogic.isValidDOB("1990-01-15"));
        assertFalse(PetitionLogic.isValidDOB("01/15/1990"));
        assertFalse(PetitionLogic.isValidDOB("01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-01-1990"));
        assertFalse(PetitionLogic.isValidDOB("15-1990-01"));
        assertFalse(PetitionLogic.isValidDOB("05-10-2050"));
        assertFalse(PetitionLogic.isValidDOB("12-31-3000"));
        assertFalse(PetitionLogic.isValidDOB("02-30-1990"));
        assertFalse(PetitionLogic.isValidDOB("04-31-1990"));
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
        petition.setPetitionData(new Object());
        petition.setEligibilityCriteria(true);
        assertTrue(petition.checkForDuplicates());
        PetitionLogic newPetition = new PetitionLogic();
        newPetition.setPetitionerName("Alice Smith");
        newPetition.setAlienFianceeName("Bob Johnson");
        newPetition.setAlienChildrenNames("Child3, Child4");
        newPetition.setAccessGrantedUnderDifferentImmigrant(true);
        newPetition.setPetitionSubmitted(false);
        newPetition.setPetitionData(new Object());
        newPetition.setEligibilityCriteria(true);
        assertFalse(newPetition.checkForDuplicates());
    }
}