package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;
import java.util.Map;

public class PetProperty {
    private Map<String, String> petProperty;

    public PetProperty(Map<String, String> petProperty) {
        this.petProperty = petProperty;
    }

    public Map<String, String> getProperties() {
        return petProperty;
    }

    public void matchProperty(PetProperty searchProperty) {
        //TODO - add code to match pet property
    }

    /**
     * addPetInfo creates an ArrayList of all possible pets
     * @param context allows access to app resources
     * @return ArrayList of PetInfo
     */
    public static ArrayList<PetInfo> addPetInfo(Context context) {
        ArrayList<PetInfo> petInformation = new ArrayList<>();
        petInformation.add(new PetInfo(
                context.getString(R.string.kitten),
                R.drawable.cat_young,
                context.getString(R.string.kitten_desc),
                context.getString(R.string.kitten_link),
                context.getString(R.string.kitten_button),
                context.getString(R.string.kitten_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.cat_adult),
                R.drawable.cat_adult,
                context.getString(R.string.cat_adult_desc),
                context.getString(R.string.cat_adult_link),
                context.getString(R.string.cat_adult_button),
                context.getString(R.string.cat_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.cat_elderly),
                R.drawable.cat_elderly,
                context.getString(R.string.cat_elderly_desc),
                context.getString(R.string.cat_elderly_link),
                context.getString(R.string.cat_elderly_button),
                context.getString(R.string.elderly_cat_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.puppy),
                R.drawable.dog_young,
                context.getString(R.string.puppy_desc),
                context.getString(R.string.puppy_link),
                context.getString(R.string.puppy_button),
                context.getString(R.string.puppy_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.dog_adult),
                R.drawable.dog_adult,
                context.getString(R.string.dog_adult_desc),
                context.getString(R.string.dog_adult_link),
                context.getString(R.string.dog_adult_button),
                context.getString(R.string.dog_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.dog_elderly),
                R.drawable.dog_elderly,
                context.getString(R.string.dog_elderly_desc),
                context.getString(R.string.dog_elderly_link),
                context.getString(R.string.dog_elderly_button),
                context.getString(R.string.elderly_dog_img_desc)));
        petInformation.add(new PetInfo(
                context.getString(R.string.misc_pets),
                R.drawable.misc_pets,
                context.getString(R.string.misc_pet_desc),
                context.getString(R.string.misc_pet_link),
                context.getString(R.string.misc_pet_button),
                context.getString(R.string.misc_pet_img_desc)));
        return petInformation;
    }
}
