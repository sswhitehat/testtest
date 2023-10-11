package unitTests;
// import com.sun.org.apache.xerces.internal.util.PropertyState;

import src.Greeting;

import org.junit.jupiter.api.Test;
// import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.jupiter.api.Assertions.*;

public class GreetingTest {

    @Test
    void test(){
        Greeting greeting = new Greeting();
        assertEquals(greeting.getMessage(), "Hello World!");
        
    }
}
