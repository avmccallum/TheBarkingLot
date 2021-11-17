package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetList {

    public static ArrayList<Pet> matchPets(ArrayList<Pet> allPets, Pet searchPet) {
        ArrayList<Pet> petResults = new ArrayList<>();
        int propertyMatches = 0;
        for(int i = 0; i < allPets.size(); i++) {
            for(String property : searchPet.getPetProperties().keySet()) {

            }
        }
        return petResults;
    }


    /**
     * addAllPets initializes an arraylist of all pet options
     * @param context allows use of String resources
     * @return ArrayList of all pets
     */
    public static ArrayList<Pet> addAllPets(Context context) {
        ArrayList<Pet> pets = new ArrayList<>();
        Map<String, String> properties = new HashMap<>();
        properties.put("petName", context.getString(R.string.kitten));
        properties.put("petDesc", context.getString(R.string.kitten_desc));
        properties.put("petLink", context.getString(R.string.kitten_link));
        properties.put("petButton", context.getString(R.string.kitten_button));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet kitten = new Pet(properties, R.drawable.cat_young, 25);
        pets.add(kitten);

        properties.put("petName", context.getString(R.string.cat_adult));
        properties.put("petDesc", context.getString(R.string.cat_adult_desc));
        properties.put("petLink", context.getString(R.string.cat_adult_link));
        properties.put("petButton", context.getString(R.string.cat_adult_button));
        properties.put("petImgDesc", context.getString(R.string.cat_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet catAdult = new Pet(properties, R.drawable.cat_adult, 15);
        pets.add(catAdult);

        properties.put("petName", context.getString(R.string.cat_elderly));
        properties.put("petDesc", context.getString(R.string.cat_elderly_desc));
        properties.put("petLink", context.getString(R.string.cat_elderly_link));
        properties.put("petButton", context.getString(R.string.cat_elderly_button));
        properties.put("petImgDesc", context.getString(R.string.elderly_cat_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet catElderly = new Pet(properties, R.drawable.cat_elderly, 7);
        pets.add(catElderly);

        properties.put("petName", context.getString(R.string.puppy));
        properties.put("petDesc", context.getString(R.string.puppy_desc));
        properties.put("petLink", context.getString(R.string.puppy_link));
        properties.put("petButton", context.getString(R.string.puppy_button));
        properties.put("petImgDesc", context.getString(R.string.puppy_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet puppy = new Pet(properties, R.drawable.dog_young, 25);
        pets.add(puppy);

        properties.put("petName", context.getString(R.string.dog_adult));
        properties.put("petDesc", context.getString(R.string.dog_adult_desc));
        properties.put("petLink", context.getString(R.string.dog_adult_link));
        properties.put("petButton", context.getString(R.string.dog_adult_button));
        properties.put("petImgDesc", context.getString(R.string.dog_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet dogAdult = new Pet(properties, R.drawable.dog_adult, 15);
        pets.add(dogAdult);

        properties.put("petName", context.getString(R.string.dog_elderly));
        properties.put("petDesc", context.getString(R.string.dog_elderly_desc));
        properties.put("petLink", context.getString(R.string.dog_elderly_link));
        properties.put("petButton", context.getString(R.string.dog_elderly_button));
        properties.put("petImgDesc", context.getString(R.string.elderly_dog_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet dogElderly = new Pet(properties, R.drawable.dog_elderly, 15);
        pets.add(dogElderly);

        properties.put("petName", context.getString(R.string.misc_pets));
        properties.put("petDesc", context.getString(R.string.misc_pet_desc));
        properties.put("petLink", context.getString(R.string.misc_pet_link));
        properties.put("petButton", context.getString(R.string.misc_pet_button));
        properties.put("petImgDesc", context.getString(R.string.misc_pet_img_desc));
        properties.put("activityLevel", "");
        properties.put("experienceRequired", "");
        properties.put("enclosureRequired", "");
        properties.put("outdoorRequired", "");
        properties.put("companionType", "");
        properties.put("groomingNeed", "");

        Pet miscPets = new Pet(properties, R.drawable.misc_pets, 7);
        pets.add(miscPets);

        return pets;
    }

}
