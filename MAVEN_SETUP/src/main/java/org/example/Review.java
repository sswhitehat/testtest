package org.example;
public class Review {
    public static void main(String[] args) {
        // Ryan made this change on test_branch
        //HARDCODED PETITIONS
        PetitionLogic[] samplePetitions = new PetitionLogic[]{
                new PetitionLogic("John Doe", "Jane Smith", "Gary Smith", 12345678, "johndoe@example.com", "01-15-1985"),
                new PetitionLogic("Alice Johnson", "Bob Brown", "Billy Brown, Larry Brown", 234567891, "jane.smith@workplace.net", "12-22-1990"),
                new PetitionLogic("Eva Miller", "David Wilson", "Jill Wilson", 31234567, "info@mywebsite.org", "07-04-1976"),
                new PetitionLogic("Mark White", "Sarah Lee", "None", 44444444, "contact_us@company.co.uk", "10-31-2000"),
                new PetitionLogic("Michael Clark", "Linda Johnson", "Linda Johnson", 51243780, "mike@.com", "05-29-1965"),
                new PetitionLogic("Sophia Martin", "William Brown", "Jeff", 612, "sarah-at-domain.com", "08-16-1988"),
                new PetitionLogic("Olivia Davis", "Matthew Smith", "Barry Bonds", 71123000, "noatmarkhere", "02-30-1995"),
                new PetitionLogic("Daniel Johnson", "Emily Wilson", "12", 0000000000001, "emily@example..com", "13-01-1980")
        };

        // Store petitions in PetitionDataStorage
        for (PetitionLogic petition : samplePetitions) {
            PetitionDataStorage.storePetitionData(petition.toPetitionData());
        }
    }
}
