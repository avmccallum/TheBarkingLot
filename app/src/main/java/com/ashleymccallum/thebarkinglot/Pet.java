package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;

public class Pet {

    /**
     * Properties for the pet display
     */
    private String petName;
    private String petDesc;
    private String petHours;
    private String petActivity;
    private String petExperience;
    private String petEnclosure;
    private String petOutdoor;
    private String petCompanion;
    private String petGrooming;
//    private String petLink;
//    private String petButton;
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

    //constructor for all pet results
    public Pet(String petName, String petHours, String petActivity, String petExperience, String petEnclosure, String petOutdoor, String petCompanion, String petGrooming, String petImgDesc, int petImage, int hoursNeeded, int groomingNeed, int activityLevel, int outdoorRequired, int enclosureRequired, int experienceRequired, int companionshipLevel) {
        this.petName = petName;
        this.petHours = petHours;
        this.petActivity = petActivity;
        this.petExperience = petExperience;
        this.petEnclosure = petEnclosure;
        this.petOutdoor = petOutdoor;
        this.petCompanion = petCompanion;
        this.petGrooming = petGrooming;
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

    //constructor for default and expert pet results
    public Pet(String petName, String petDesc, int petImage, String petImgDesc) {
        this.petName = petName;
        this.petDesc = petDesc;
        this.petImage = petImage;
        this.petImgDesc = petImgDesc;
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

    public String getPetHours() {
        return petHours;
    }

    public String getPetActivity() {
        return petActivity;
    }

    public String getPetExperience() {
        return petExperience;
    }

    public String getPetEnclosure() {
        return petEnclosure;
    }

    public String getPetOutdoor() {
        return petOutdoor;
    }

    public String getPetCompanion() {
        return petCompanion;
    }

    public String getPetGrooming() {
        return petGrooming;
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

    public static ArrayList<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet, Context context) {
        ArrayList<Pet> petResults = new ArrayList<>();
        int emptyCount = 0;

        //check how many questions were not answered
        for(int i = 0; i < searchPet.petNeeds.length; i++) {
            if(searchPet.petNeeds[i] == 3) {
                emptyCount ++;
            }
        }

        //for each pet in the possible results
        for(Pet pet : allPets) {
            int propertyMatches = 0;
            for(int i = 0; i < pet.petNeeds.length; i++) {

                //check if each need matches the search query
                if(pet.petNeeds[i] == searchPet.petNeeds[i]) {
                    propertyMatches ++;
                }
            }

            //if there are 3 or more matches add pet to result list
            if(propertyMatches > 3) {
                petResults.add(pet);
            }
        }

        //if user answered they were an expert for second to last question (expertise), add exert pet to list
        if(searchPet.petNeeds[searchPet.petNeeds.length - 2] == 2) {
            petResults.add(new Pet(context.getString(R.string.expert_pet), context.getString(R.string.expert_desc), R.drawable.cat_elderly, context.getString(R.string.expert_pet_img_desc)));
        }

        //if half the questions were unanswered, remove all answers from the list
        if(emptyCount >= searchPet.petNeeds.length / 2) {
            petResults.clear();
        }

        //if there are no answers, return the default
        if(petResults.isEmpty()) {
            petResults.add(new Pet(context.getString(R.string.default_pet), context.getString(R.string.default_desc), R.drawable.cat_elderly, context.getString(R.string.default_pet_img_desc)));
        }

        return petResults;
    }
}
