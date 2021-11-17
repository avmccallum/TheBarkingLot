package com.ashleymccallum.thebarkinglot;

import java.util.Map;

public class Pet {

    private Map<String, String> petProperties;
    private int petImage;

    public Pet(Map<String, String> petProperties, int petImage) {
        this.petProperties = petProperties;
        this.petImage = petImage;
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

    //    private String petName;
//    private int petImage;
//    private String description;
//    private String petLink;
//    private String petButtonName;
//    private String petImageDesc;
//
//    public PetInfo(String petName, int petImage, String description, String petLink, String petButtonName, String petImageDesc) {
//        this.petName = petName;
//        this.petImage = petImage;
//        this.description = description;
//        this.petLink = petLink;
//        this.petButtonName = petButtonName;
//        this.petImageDesc = petImageDesc;
//    }
//
//    public String getPetName() {
//        return petName;
//    }
//
//    public int getPetImage() {
//        return petImage;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getPetLink() {
//        return petLink;
//    }
//
//    public String getPetButtonName() {
//        return petButtonName;
//    }
//
//    public String getPetImageDesc() {
//        return petImageDesc;
//    }
}
