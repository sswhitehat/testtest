package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
// import src.DataEntry;

public class DataEntryTest {
    
    @Test
    void test() {
        DataEntry entry = new DataEntry();
        assertEquals("Entered data!", entry.enterData());
    }
}
