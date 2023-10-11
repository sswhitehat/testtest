package unitTests;
import static org.junit.jupiter.api.Assertions.*;

import src.DataEntry;
public class DataEntryTest {
    
    @org.junit.jupiter.api.Test
    void test() {
        DataEntry entry = new DataEntry();
        assertEquals(entry.enterData(), "Entered data!");
    }
}
