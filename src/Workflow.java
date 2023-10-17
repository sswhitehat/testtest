package src;

import java.util.LinkedList;
import java.util.Queue;

public class Workflow {
    
    /**
     * Queue for storing reviewer work
     */
    Queue<PetitionLogic> reviewQueue = new LinkedList<PetitionLogic>();
    
    /**
     * Queue for storing approval work
     */
    Queue<PetitionLogic> approvalQueue = new LinkedList<PetitionLogic>();
    
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
        boolean ret = reviewQueue.add(work);
        return ret;
    }
    
    /**
     * Retrieves work for reviwer to do
     * @return PetitionLogic
     */
    public PetitionLogic retrieveReviewWork() {
        
        PetitionLogic work;
        
        if (approvalQueue.isEmpty())
            work = null;
        
        else
            work = reviewQueue.peek();
            reviewQueue.remove();
        
        return work;
    }
    
    /**
     * Retrieves work for the approver to do
     * @return PetitionLogic
     */
    public PetitionLogic retrieveApprovalWork() {
        
        PetitionLogic work;
        
        if (approvalQueue.isEmpty())
            work = null;
        
        else
            work = approvalQueue.peek();
            approvalQueue.remove();
        
        return work;
    }
    
}
