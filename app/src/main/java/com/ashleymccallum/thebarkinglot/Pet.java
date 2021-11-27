package com.ashleymccallum.thebarkinglot;

import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    private int hoursNeeded;
    private int groomingNeed;
    private int activityLevel;
    private int outdoorRequired;
    private int enclosureRequired;
    private int experienceRequired;
    private int companionshipLevel;

    /**
     * Property to hold pet information in an easily accessible way
     * To be used in comparison
     */
    private int[] petNeeds;

    public Pet(String petName, String petDesc, String petLink, String petButton, String petImgDesc, int petImage, int hoursNeeded, int groomingNeed, int activityLevel, int outdoorRequired, int enclosureRequired, int experienceRequired, int companionshipLevel) {
        this.petName = petName;
        this.petDesc = petDesc;
        this.petLink = petLink;
        this.petButton = petButton;
        this.petImgDesc = petImgDesc;
        this.petImage = petImage;
        this.hoursNeeded = hoursNeeded;
        this.groomingNeed = groomingNeed;
        this.activityLevel = activityLevel;
        this.outdoorRequired = outdoorRequired;
        this.enclosureRequired = enclosureRequired;
        this.experienceRequired = experienceRequired;
        this.companionshipLevel = companionshipLevel;
    }

    public Pet(int[] petNeeds) {
        this.petNeeds = petNeeds;
    }

    public int[] getPetNeeds() {
        return new int[] {
                this.hoursNeeded,
                this.groomingNeed,
                this.activityLevel,
                this.outdoorRequired,
                this.enclosureRequired,
                this.experienceRequired,
                this.companionshipLevel
        };
    }

    public void setPetNeeds() {
        this.petNeeds = new int[]{
                this.hoursNeeded,
                this.groomingNeed,
                this.activityLevel,
                this.outdoorRequired,
                this.enclosureRequired,
                this.experienceRequired,
                this.companionshipLevel
        };
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
     * Compares the needs of each pet to the pet query
     * @param allPets is the ArrayList containing all possible pets
     * @param searchPet is the query created by the pet quiz
     * @return ArrayList of matching pets
     */

    public static ArrayList<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet) {
        ArrayList<Pet> petResults = new ArrayList<>();

        for(Pet pet : allPets) {
            int propertyMatches = 0;

            for(int i = 0; i < pet.petNeeds.length; i++) {

                if(pet.petNeeds[i] == searchPet.petNeeds[i]) {
                    propertyMatches ++;
                }
            }

            if(propertyMatches > 3) {
                petResults.add(pet);
            }
        }

        if(!petResults.isEmpty()) {
            return petResults;
        } else {
            //TODO - if user gets no match or does not answer questions return default pet (also return if user does not answer a certain number of questions)
            return petResults;
        }

    }
}
