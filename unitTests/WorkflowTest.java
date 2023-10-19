package unitTests;

import org.junit.jupiter.api.Test;
import src.PetitionLogic;
import src.Workflow;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkflowTest { 
  
    // @Test
    // void genericTest() {
    //     Workflow wf = new Workflow();
    //     assertEquals("New item!", wf.insertItem("New item!"));
    // }
    
    
    /**
     * Tests storing an petition in the review queue
     */
    @Test
    void storingReviewItems() {
        Workflow wf = new Workflow();
        PetitionLogic petition1 = new PetitionLogic();
        boolean ret = wf.queueReviewWork(petition1);
        assert(ret == true);
    }
    
    /**
     * Tests storing an petition in the review queue
     */
    @Test
    void storingApprovalItems() {
        Workflow wf = new Workflow();
        PetitionLogic petition1 = new PetitionLogic();
        boolean ret = wf.queueApprovalWork(petition1);
        assert(ret == true);
    }
    
    /**
     * Tests storing and retrieving petitions from the review workflow queue
     */
    @Test
    void storingAndRetrievingReviewItems() {
        
        Workflow wf = new Workflow();
        
        PetitionLogic petition1 = new PetitionLogic();
        PetitionLogic petition2 = new PetitionLogic();
        PetitionLogic petition3 = new PetitionLogic();
        
        wf.queueReviewWork(petition1);
        wf.queueReviewWork(petition2);
        wf.queueReviewWork(petition3);
        
        PetitionLogic returnedItem = wf.retrieveReviewWork();
        
        assert(returnedItem != null);
        assertEquals(petition1, returnedItem);
        
        returnedItem = wf.retrieveReviewWork();
        
        assert(returnedItem != null);
        assertEquals(petition2, returnedItem);
        
        returnedItem = wf.retrieveReviewWork();
        
        assert(returnedItem != null);
        assertEquals(petition3, returnedItem);
    }
    /**
     * Tests storing and retrieving petitions from the approval workflow queue
     */    
    @Test
    void storingAndRetrievingApprovalItems() {
        
        Workflow wf = new Workflow();
        
        PetitionLogic petition1 = new PetitionLogic();
        PetitionLogic petition2 = new PetitionLogic();
        PetitionLogic petition3 = new PetitionLogic();
        
        wf.queueApprovalWork(petition1);
        wf.queueApprovalWork(petition2);
        wf.queueApprovalWork(petition3);
        
        PetitionLogic returnedItem = wf.retrieveApprovalWork();
        
        assert(returnedItem != null);
        assertEquals(petition1, returnedItem);
        
        returnedItem = wf.retrieveApprovalWork();
        
        assert(returnedItem != null);
        assertEquals(petition2, returnedItem);
        
        returnedItem = wf.retrieveApprovalWork();
        
        assert(returnedItem != null);
        assertEquals(petition3, returnedItem);
    }
    /*
     * Tests storing and retrieving null petitions from the review workflow queue
     */
    @Test
    void storingAndRetrievingReviewNullItems(){
        Workflow wf = new Workflow();
        PetitionLogic returnedItem = wf.retrieveReviewWork();

        assert(returnedItem == null);
    }
    /**
     * Tests storing and retrieving null petitions from the approval workflow queue
     */ 
    @Test
    void storingAndRetrievingApprovalNullItems(){
        Workflow wf = new Workflow();
        PetitionLogic returnedItem = wf.retrieveApprovalWork();

        assert(returnedItem == null);
    }
}
