package org.example;

import java.util.HashMap;
import java.util.Map;

public class PetitionDataStorage {
    // Static HashMap to act as an in-memory database
    private static final Map<String, PetitionLogic.PetitionData> petitions = new HashMap<>();

    // Method to store petition data
    public static void storePetitionData(PetitionLogic.PetitionData data) {
        if (data != null && data.petitionerName != null && !data.petitionerName.trim().isEmpty()) {
            petitions.put(data.petitionerName, data);
        } else {
            throw new IllegalArgumentException("Petitioner name is required to store petition data.");
        }
    }

    // Method to retrieve petition data
    public static PetitionLogic.PetitionData getPetitionData(String petitionerName) {
        return petitions.get(petitionerName);
    }

    // Method to check if a petition already exists
    public static boolean isDuplicatePetition(String petitionerName) {
        return petitions.containsKey(petitionerName);
    }
}