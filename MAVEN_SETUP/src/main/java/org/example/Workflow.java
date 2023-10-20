package org.example;

import java.util.LinkedList;
import java.util.Queue;
// import src.PetitionLogic;
public class Workflow {
    
    /**
     * Queue for storing reviewer work
     */
    private Queue<PetitionLogic> reviewQueue = new LinkedList<PetitionLogic>();
    
    /**
     * Queue for storing approval work
     */
    private Queue<PetitionLogic> approvalQueue = new LinkedList<PetitionLogic>();
    
    /**
     * Constructor for Workflow
     */
    public Workflow(){
        this.reviewQueue = new LinkedList<PetitionLogic>();
        this.approvalQueue = new LinkedList<PetitionLogic>();
    }
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
            work = reviewQueue.remove();
            
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
            work = approvalQueue.remove();
        
        return work;
    }
    
}
