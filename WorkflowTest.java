import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import src.Workflow;

public class WorkflowTest { 
  
    @Test
    void genericTest() {
        Workflow wf = new Workflow();
        assertEquals("New item!", wf.insertItem("New item!"));
    }
}
