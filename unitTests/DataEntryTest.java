package unitTests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.DataEntry;

public class DataEntryTest {
    
    @Test
    void test() {
        DataEntry entry = new DataEntry();
        assertEquals(entry.enterData(), "Entered data!");
    }
}
