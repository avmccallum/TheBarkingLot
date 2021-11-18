package com.ashleymccallum.thebarkinglot;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;

public class Pet {

    private Map<String, String> petProperties;
    private int petImage;
    private int hoursNeeded;

    public Pet(Map<String, String> petProperties, int petImage, int hoursNeeded) {
        this.petProperties = petProperties;
        this.petImage = petImage;
        this.hoursNeeded = hoursNeeded;
    }

    public Map<String, String> getPetProperties() {
        return petProperties;
    }

    public String getProperty(String propertyName) {
        return petProperties.get(propertyName);
    }

    public int getPetImage() {
        return petImage;
    }

    public int getHoursNeeded() {
        return hoursNeeded;
    }

    /**
     * Searches through all possible pets to find a matching result for the pet query created by the quiz
     *
     * @param allPets is the ArrayList containing all possible pets
     * @param searchPet is the query created by the pet quiz
     * @return ArrayList of matching pets
     */
    public static LinkedHashSet<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet) {
        LinkedHashSet<Pet> petResults = new LinkedHashSet<>();

        //for each pet in the allPets list
        for(Pet pet : allPets) {
            int propertyMatches = 0;
            //cycle through each property provided by the search pet (only search with properties provided)
            for(String property : searchPet.getPetProperties().keySet()) {
                //if the pet property matches the search pet property
                if(pet.getProperty(property).equals(searchPet.getProperty(property))) {
                    //increase property matches
                    propertyMatches ++;
                    if(propertyMatches > 3) {
                        petResults.add(pet);
                    }
                }
            }

            //if the pet hoursNeeded is less than or equal to search pet hoursNeeded
            if(pet.getHoursNeeded() <= searchPet.hoursNeeded) {
                //increase property matches
                propertyMatches ++;
                if(propertyMatches > 3) {
                    petResults.add(pet);
                }
            }

            //if property matches is greater than or equal to 3, add it to the results list
//            if (propertyMatches >= 3) {
//                petResults.add(pet);
//            }
        }
        return petResults;
    }
}
