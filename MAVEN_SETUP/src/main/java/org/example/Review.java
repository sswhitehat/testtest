package org.example;
public class Review {
    public static void main(String[] args) {
        //HARDCODED PETITIONS
        PetitionLogic[] samplePetitions = new PetitionLogic[]{
                new PetitionLogic("John Doe", "Jane Smith", "Child1, Child2", 1, true, true),
                new PetitionLogic("Alice Johnson", "Bob Brown", "Child3, Child4", 2, true, false),
                new PetitionLogic("Eva Miller", "David Wilson", "Child5, Child6", 3, true, true),
                new PetitionLogic("Mark White", "Sarah Lee", "Child7, Child8", 4, false, false),
                new PetitionLogic("Michael Clark", "Linda Johnson", "Child9, Child10", 5, true, false),
                new PetitionLogic("Sophia Martin", "William Brown", "Child11, Child12", 6, true, true),
                new PetitionLogic("Olivia Davis", "Matthew Smith", "Child13, Child14", 7, true, false),
                new PetitionLogic("Daniel Johnson", "Emily Wilson", "Child15, Child16", 8, true, true)
        };

        // Store petitions in PetitionDataStorage
        for (PetitionLogic petition : samplePetitions) {
            PetitionDataStorage.storePetitionData(petition.toPetitionData());
        }
    }
}
