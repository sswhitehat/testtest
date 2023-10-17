import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import src.PetitionLogic;
import src.Workflow;

public class WorkflowTest { 
  
    // @Test
    // void genericTest() {
    //     Workflow wf = new Workflow();
    //     assertEquals("New item!", wf.insertItem("New item!"));
    // }
    
    /**
     * Tests storing and retrieving items from the review workflow queue
     */
    @Test
    void storingAndRetrievingReviewItems() {
        
        Workflow wf = new Workflow();
        PetitionLogic item1, item2, item3 = createNewPetition();
        
        wf.queueReviewWork(item1);
        wf.queueReviewWork(item2);
        wf.queueReviewWork(item3);
        
        PetitionLogic returnedItem = wf.retrieveReviewWork();
        
        assert(returnedItem != null);
        assertEquals(item1, returnedItem);
    }
    /**
     * Tests storing and retrieving items from the approval workflow queue
     */    
    @Test
    void storingAndRetrievingApprovalItems() {
        
        Workflow wf = new Workflow();
        PetitionLogic item1, item2, item3 = createNewPetition();
        
        wf.queueApprovalWork(item1);
        wf.queueApprovalWork(item2);
        wf.queueApprovalWork(item3);
        
        PetitionLogic returnedItem = wf.retrieveApprovalWork();
        
        assert(returnedItem != null);
        assertEquals(item1, returnedItem);
    }
}
