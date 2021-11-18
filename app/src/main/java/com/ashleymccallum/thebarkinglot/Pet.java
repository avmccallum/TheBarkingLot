package com.ashleymccallum.thebarkinglot;

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
     */
    private PetRequirement activityLevel;
    private PetRequirement experienceRequired;
    private PetRequirement enclosureRequired;
    private PetRequirement outdoorRequired;
    private PetRequirement companionshipLevel;
    private PetRequirement groomingNeed;
    private int hoursNeeded;

    public Pet(String petName, String petDesc, String petLink, String petButton, String petImgDesc, int petImage, PetRequirement activityLevel, PetRequirement experienceRequired, PetRequirement enclosureRequired, PetRequirement outdoorRequired, PetRequirement companionshipLevel, PetRequirement groomingNeed, int hoursNeeded) {
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

    public Pet(PetRequirement activityLevel, PetRequirement experienceRequired, PetRequirement enclosureRequired, PetRequirement outdoorRequired, PetRequirement companionshipLevel, PetRequirement groomingNeed, int hoursNeeded) {
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

    public PetRequirement getActivityLevel() {
        return activityLevel;
    }

    public PetRequirement getExperienceRequired() {
        return experienceRequired;
    }

    public PetRequirement getEnclosureRequired() {
        return enclosureRequired;
    }

    public PetRequirement getOutdoorRequired() {
        return outdoorRequired;
    }

    public PetRequirement getCompanionshipLevel() {
        return companionshipLevel;
    }

    public PetRequirement getGroomingNeed() {
        return groomingNeed;
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
//    public static LinkedHashSet<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet) {
//        LinkedHashSet<Pet> petResults = new LinkedHashSet<>();
//        int propertyMatches = 0;
//        //for each pet in the allPets list
//        for(Pet pet : allPets) {
//            //cycle through each property provided by the search pet (only search with properties provided)
//            for(String property : searchPet.getPetProperties().keySet()) {
//                //if the pet property matches the search pet property
//                if(pet.getProperty(property).equals(searchPet.getProperty(property))) {
//                    //increase property matches
//                    propertyMatches ++;
////                    if(propertyMatches > 3) {
////                        petResults.add(pet);
////                    }
//                }
//            }
//
//            //if the pet hoursNeeded is less than or equal to search pet hoursNeeded
//            if(pet.getHoursNeeded() <= searchPet.hoursNeeded) {
//                //increase property matches
//                propertyMatches ++;
////                if(propertyMatches > 3) {
////                    petResults.add(pet);
////                }
//            }
//
//            //if property matches is greater than or equal to 3, add it to the results list
//            if (propertyMatches >= 3) {
//                petResults.add(pet);
//            }
//        }
//        return petResults;
//    }
}
