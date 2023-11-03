/*
package org.example;
public class Approve{
    public static void main(String[] args) {
        
        Workflow wf = new Workflow();
        // Initialize 8 instances of PetitionLogic with sample data
        PetitionLogic[] petitions = new PetitionLogic[8];

        petitions[0] = new PetitionLogic("John Doe", "Jane Smith", "Child1, Child2", true, true, true);
        petitions[1] = new PetitionLogic("Alice Johnson", "Bob Brown", "Child3, Child4", true, true, false);
        petitions[2] = new PetitionLogic("Eva Miller", "David Wilson", "Child5, Child6", false, true, true);
        petitions[3] = new PetitionLogic("Mark White", "Sarah Lee", "Child7, Child8", false, false, false);
        petitions[4] = new PetitionLogic("Michael Clark", "Linda Johnson", "Child9, Child10", true, true, false);
        petitions[5] = new PetitionLogic("Sophia Martin", "William Brown", "Child11, Child12", false, true, true);
        petitions[6] = new PetitionLogic("Olivia Davis", "Matthew Smith", "Child13, Child14", true, true, false);
        petitions[7] = new PetitionLogic("Daniel Johnson", "Emily Wilson", "Child15, Child16", false, true, true);
        
        // Queue the petitions
        for (int x = 0; x < petitions.length; x++) {
            wf.queueReviewWork(petitions[x]);
        }
        
        PetitionLogic currentPetition;
        while (wf.retrieveReviewWork() != null) {
            wf.retrieveReviewWork();
        }
        
    }
}*/
