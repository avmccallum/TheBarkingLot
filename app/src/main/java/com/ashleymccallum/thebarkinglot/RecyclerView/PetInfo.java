package com.ashleymccallum.thebarkinglot.RecyclerView;

public class PetInfo {
    private String petName;
    private int petImage;
    private String description;
    private String petLink;

    public PetInfo(String petName, int petImage, String description, String petLink) {
        this.petName = petName;
        this.petImage = petImage;
        this.description = description;
        this.petLink = petLink;
    }

    public PetInfo(String petName, int petImage) {
        this.petName = petName;
        this.petImage = petImage;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetImage() {
        return petImage;
    }

    public void setPetImage(int petImage) {
        this.petImage = petImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPetLink() {
        return petLink;
    }

    public void setPetLink(String petLink) {
        this.petLink = petLink;
    }
}
