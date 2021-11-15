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

    public int getPetImage() {
        return petImage;
    }

    public String getDescription() {
        return description;
    }

    public String getPetLink() {
        return petLink;
    }

    public String getPetButtonName() {
        return petButtonName;
    }

    public String getPetImageDesc() {
        return petImageDesc;
    }
}
