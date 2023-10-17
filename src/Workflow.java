package src;

import java.util.LinkedList;
import java.util.Queue;

public class Workflow {
    
    /**
     * Queue for storing reviewer work
     */
    LinkedList<PetitionLogic> reviewQueue = new LinkedList<PetitionLogic>();
    
    /**
     * Queue for storing approval work
     */
    LinkedList<PetitionLogic> approvalQueue = new LinkedList<PetitionLogic>();
    
    /**
     * Queues work for the reviewer to do
     * @param work for reviewer
     * @return Always returns true
     */
    public boolean queueReviewWork(PetitionLogic work) {
        boolean ret = reviewQueue.add(work);
        return ret;
    }
    
    /**
     * Queues work for the approver to do
     * @param work for approver
     * @return Always returns true
     */
    public boolean queueApprovalWork(PetitionLogic work) {
        boolean ret = approvalQueue.add(work);
        return ret;
    }
    
    /**
     * Retrieves work for reviewer to do
     * @return PetitionLogic
     */
    public PetitionLogic retrieveReviewWork() {
        
        PetitionLogic work;
        
        if (reviewQueue.peek() == null)
            work = null;
        
        else
<<<<<<< HEAD
            work = reviewQueue.peek();

=======
            work = reviewQueue.remove();
        
>>>>>>> a59305037c770ad1a33385138570c49c2ac853df
        return work;
    }
    
    /**
     * Retrieves work for the approver to do
     * @return PetitionLogic
     */
    public PetitionLogic retrieveApprovalWork() {
        
        PetitionLogic work;
        
        if (approvalQueue.peek() == null)
            work = null;
        
        else
<<<<<<< HEAD
            work = approvalQueue.peek();
=======
            work = approvalQueue.remove();
>>>>>>> a59305037c770ad1a33385138570c49c2ac853df
        
        return work;
    }
    
}
