package org.example;

// import com.sun.org.apache.xerces.internal.util.PropertyState;
// import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

// import src.Greeting;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GreetingTest {

    @Test
    void test(){
        Greeting greeting = new Greeting();
        assertEquals("Hello World!", greeting.getMessage());
    }
}
