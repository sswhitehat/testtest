import static org.junit.jupiter.api.Assertions.*;
public class DataEntryTest {
    
    @org.junit.jupiter.api.Test
    void test() {
        DataEntry entry = new DataEntry();
        assertEquals(entry.enterData(), "Entered data!");
    }
}
