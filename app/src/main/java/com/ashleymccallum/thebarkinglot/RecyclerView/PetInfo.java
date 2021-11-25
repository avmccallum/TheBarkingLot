package com.ashleymccallum.thebarkinglot.RecyclerView;

public class PetInfo {
    private String petName;
    private int petImage;
    private String description;
    private String petLink;
    private String petButtonName;
    private String petImageDesc;

    public PetInfo(String petName, int petImage, String description, String petLink, String petButtonName, String petImageDesc) {
        this.petName = petName;
        this.petImage = petImage;
        this.description = description;
        this.petLink = petLink;
        this.petButtonName = petButtonName;
        this.petImageDesc = petImageDesc;
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

    public String getPetButtonName() {
        return petButtonName;
    }

    public void setPetButtonName(String petButtonName) {
        this.petButtonName = petButtonName;
    }

    public String getPetImageDesc() {
        return petImageDesc;
    }

    public void setPetImageDesc(String petImageDesc) {
        this.petImageDesc = petImageDesc;
    }
}
