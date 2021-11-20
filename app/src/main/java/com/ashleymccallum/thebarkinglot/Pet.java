package com.ashleymccallum.thebarkinglot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;

public class Pet {

    /**
     * Properties for the pet display
     */
    private String petName;
    private String petDesc;
    private String petLink;
    private String petButton;
    private String petImgDesc;
    private int petImage;

    /**
     * Properties for the pet information
     * To be used in finding matches
     * 0 = minimal or no need, very occasional
     * 1 = moderate need, could be regular but not strenuous
     * 2 = maximum need, mandatory, requires regularly
     */
    private int activityLevel;
    private int experienceRequired;
    private int enclosureRequired;
    private int outdoorRequired;
    private int companionshipLevel;
    private int groomingNeed;
    private int hoursNeeded;

    public Pet(String petName, String petDesc, String petLink, String petButton, String petImgDesc, int petImage, int activityLevel, int experienceRequired, int enclosureRequired, int outdoorRequired, int companionshipLevel, int groomingNeed, int hoursNeeded) {
        this.petName = petName;
        this.petDesc = petDesc;
        this.petLink = petLink;
        this.petButton = petButton;
        this.petImgDesc = petImgDesc;
        this.petImage = petImage;
        this.activityLevel = activityLevel;
        this.experienceRequired = experienceRequired;
        this.enclosureRequired = enclosureRequired;
        this.outdoorRequired = outdoorRequired;
        this.companionshipLevel = companionshipLevel;
        this.groomingNeed = groomingNeed;
        this.hoursNeeded = hoursNeeded;
    }

    public Pet(int activityLevel, int experienceRequired, int enclosureRequired, int outdoorRequired, int companionshipLevel, int groomingNeed, int hoursNeeded) {
        this.activityLevel = activityLevel;
        this.experienceRequired = experienceRequired;
        this.enclosureRequired = enclosureRequired;
        this.outdoorRequired = outdoorRequired;
        this.companionshipLevel = companionshipLevel;
        this.groomingNeed = groomingNeed;
        this.hoursNeeded = hoursNeeded;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetDesc() {
        return petDesc;
    }

    public String getPetLink() {
        return petLink;
    }

    public String getPetButton() {
        return petButton;
    }

    public String getPetImgDesc() {
        return petImgDesc;
    }

    public int getPetImage() {
        return petImage;
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

        for(Pet pet : allPets) {
            int propertyMatches = 0;

            if(searchPet.activityLevel == pet.activityLevel) {
                propertyMatches ++;
            }

            if(searchPet.experienceRequired == pet.experienceRequired) {
                propertyMatches ++;
            }

            if(searchPet.enclosureRequired == pet.enclosureRequired) {
                propertyMatches ++;
            }

            if(searchPet.outdoorRequired == pet.outdoorRequired) {
                propertyMatches ++;
            }

            if(searchPet.companionshipLevel == pet.companionshipLevel) {
                propertyMatches ++;
            }

            if(searchPet.groomingNeed == pet.groomingNeed) {
                propertyMatches ++;
            }

            if(searchPet.hoursNeeded == pet.hoursNeeded) {
                propertyMatches ++;
            }

            if(propertyMatches > 3) {
                petResults.add(pet);
            }
        }
        return petResults;
    }
}
