package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetList {

//    private ArrayList<Pet> allPets;
//
//    public PetList(ArrayList<Pet> allPets) {
//        this.allPets = allPets;
//    }

    public static ArrayList<Pet> addAllPets(Context context) {
        ArrayList<Pet> pets = new ArrayList<>();
        Map<String, String> properties = new HashMap<>();
        properties.put("petName", context.getString(R.string.kitten));
        properties.put("petDesc", context.getString(R.string.kitten_desc));
        properties.put("petLink", context.getString(R.string.kitten_link));
        properties.put("petButton", context.getString(R.string.kitten_button));
        properties.put("petImgDesc", context.getString(R.string.kitten_img_desc));

        Pet kitten = new Pet(properties, R.drawable.cat_young);
        pets.add(kitten);

        properties.put("petName", context.getString(R.string.cat_adult));
        properties.put("petDesc", context.getString(R.string.cat_adult_desc));
        properties.put("petLink", context.getString(R.string.cat_adult_link));
        properties.put("petButton", context.getString(R.string.cat_adult_button));
        properties.put("petImgDesc", context.getString(R.string.cat_img_desc));

        Pet catAdult = new Pet(properties, R.drawable.cat_adult);
        pets.add(catAdult);

        properties.put("petName", context.getString(R.string.cat_elderly));
        properties.put("petDesc", context.getString(R.string.cat_elderly_desc));
        properties.put("petLink", context.getString(R.string.cat_elderly_link));
        properties.put("petButton", context.getString(R.string.cat_elderly_button));
        properties.put("petImgDesc", context.getString(R.string.elderly_cat_img_desc));

        Pet catElderly = new Pet(properties, R.drawable.cat_elderly);
        pets.add(catElderly);

        properties.put("petName", context.getString(R.string.puppy));
        properties.put("petDesc", context.getString(R.string.puppy_desc));
        properties.put("petLink", context.getString(R.string.puppy_link));
        properties.put("petButton", context.getString(R.string.puppy_button));
        properties.put("petImgDesc", context.getString(R.string.puppy_img_desc));

        Pet puppy = new Pet(properties, R.drawable.dog_young);
        pets.add(puppy);

        properties.put("petName", context.getString(R.string.dog_adult));
        properties.put("petDesc", context.getString(R.string.dog_adult_desc));
        properties.put("petLink", context.getString(R.string.dog_adult_link));
        properties.put("petButton", context.getString(R.string.dog_adult_button));
        properties.put("petImgDesc", context.getString(R.string.dog_img_desc));

        Pet dogAdult = new Pet(properties, R.drawable.dog_adult);
        pets.add(dogAdult);

        properties.put("petName", context.getString(R.string.dog_elderly));
        properties.put("petDesc", context.getString(R.string.dog_elderly_desc));
        properties.put("petLink", context.getString(R.string.dog_elderly_link));
        properties.put("petButton", context.getString(R.string.dog_elderly_button));
        properties.put("petImgDesc", context.getString(R.string.elderly_dog_img_desc));

        Pet dogElderly = new Pet(properties, R.drawable.dog_elderly);
        pets.add(dogElderly);

        properties.put("petName", context.getString(R.string.misc_pets));
        properties.put("petDesc", context.getString(R.string.misc_pet_desc));
        properties.put("petLink", context.getString(R.string.misc_pet_link));
        properties.put("petButton", context.getString(R.string.misc_pet_button));
        properties.put("petImgDesc", context.getString(R.string.misc_pet_img_desc));

        Pet miscPets = new Pet(properties, R.drawable.misc_pets);
        pets.add(miscPets);

        return pets;
    }

    public void matchProperty(PetList searchProperty) {
        //TODO - add code to match pet property
    }

    /**
     * addPetInfo creates an ArrayList of all possible pets
     * @param context allows access to app resources
     * @return ArrayList of PetInfo
     */
//    public static ArrayList<PetInfo> addPetInfo(Context context) {
//        ArrayList<PetInfo> petInformation = new ArrayList<>();
//        petInformation.add(new PetInfo(
//                context.getString(R.string.kitten),
//                R.drawable.cat_young,
//                context.getString(R.string.kitten_desc),
//                context.getString(R.string.kitten_link),
//                context.getString(R.string.kitten_button),
//                context.getString(R.string.kitten_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.cat_adult),
//                R.drawable.cat_adult,
//                context.getString(R.string.cat_adult_desc),
//                context.getString(R.string.cat_adult_link),
//                context.getString(R.string.cat_adult_button),
//                context.getString(R.string.cat_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.cat_elderly),
//                R.drawable.cat_elderly,
//                context.getString(R.string.cat_elderly_desc),
//                context.getString(R.string.cat_elderly_link),
//                context.getString(R.string.cat_elderly_button),
//                context.getString(R.string.elderly_cat_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.puppy),
//                R.drawable.dog_young,
//                context.getString(R.string.puppy_desc),
//                context.getString(R.string.puppy_link),
//                context.getString(R.string.puppy_button),
//                context.getString(R.string.puppy_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.dog_adult),
//                R.drawable.dog_adult,
//                context.getString(R.string.dog_adult_desc),
//                context.getString(R.string.dog_adult_link),
//                context.getString(R.string.dog_adult_button),
//                context.getString(R.string.dog_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.dog_elderly),
//                R.drawable.dog_elderly,
//                context.getString(R.string.dog_elderly_desc),
//                context.getString(R.string.dog_elderly_link),
//                context.getString(R.string.dog_elderly_button),
//                context.getString(R.string.elderly_dog_img_desc)));
//        petInformation.add(new PetInfo(
//                context.getString(R.string.misc_pets),
//                R.drawable.misc_pets,
//                context.getString(R.string.misc_pet_desc),
//                context.getString(R.string.misc_pet_link),
//                context.getString(R.string.misc_pet_button),
//                context.getString(R.string.misc_pet_img_desc)));
//        return petInformation;
//    }
}
