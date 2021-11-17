package com.ashleymccallum.thebarkinglot;

import java.util.ArrayList;
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
    public static ArrayList<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet) {
        ArrayList<Pet> petResults = new ArrayList<>();
        int propertyMatches = 0;
        for(int i = 0; i < allPets.size(); i++) {
            for(String property : searchPet.getPetProperties().keySet()) {
                if(allPets.get(i).getProperty(property).equals(searchPet.getProperty(property))) {
                    propertyMatches ++;
                }
            }
            if(allPets.get(i).getHoursNeeded() <= searchPet.hoursNeeded) {
                propertyMatches ++;
            }
            if (propertyMatches >= 3) {
                petResults.add(allPets.get(i));
            }
        }
        return petResults;
    }
}
