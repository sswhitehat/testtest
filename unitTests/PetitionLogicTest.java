package unitTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.PetitionLogic;

class PetitionLogicTest {

    @Test
    void createNewPetition() {
    }

    @Test
    void testGetPetition() {
        PetitionLogic petitionLogic = new PetitionLogic("John Doe", "Jane Smith", "Child1, Child2", false, true, new Object(), null, false);

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
        assertTrue(petitionData != null);
        assertFalse(duplicateCheckResults);
    }

    @Test
    void validatePetition() {
    }

    @Test
    void isValidANumber() {
    }

    @Test
    void isValidEmail() {
    }

    @Test
    void isValidDOB() {
    }

    @Test
    void checkForDuplicates() {
    }

    @Test
    void main() {
    }
}