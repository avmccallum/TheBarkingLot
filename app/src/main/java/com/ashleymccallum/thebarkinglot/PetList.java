package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetList {

    public static ArrayList<Pet> resultPets;

    public static void setResultPets(ArrayList<Pet> resultPets) {
        PetList.resultPets = resultPets;
    }

    public static ArrayList<Pet> getResultPets() {
        return resultPets;
    }

    /**
     * addAllPets initializes an arraylist of all pet options
     * @param context allows use of String resources
     * @return ArrayList of all pets
     */
    public static ArrayList<Pet> initializePets(Context context) {
        ArrayList<Pet> pets = new ArrayList<>();
        Pet kitten = new Pet(
                context.getString(R.string.kitten),
                context.getString(R.string.kitten_desc),
                context.getString(R.string.kitten_link),
                context.getString(R.string.kitten_button),
                context.getString(R.string.kitten_img_desc),
                R.drawable.cat_young,
                2, 1, 1, 0, 1, 1, 2);
        kitten.setPetNeeds();

        pets.add(kitten);

        Pet catAdult = new Pet(
                context.getString(R.string.cat_adult),
                context.getString(R.string.cat_adult_desc),
                context.getString(R.string.cat_adult_link),
                context.getString(R.string.cat_adult_button),
                context.getString(R.string.cat_img_desc),
                R.drawable.cat_adult,
                1, 1, 0, 0, 0, 0, 1);
        catAdult.setPetNeeds();

        pets.add(catAdult);

        Pet catElderly = new Pet(
                context.getString(R.string.cat_elderly),
                context.getString(R.string.cat_elderly_desc),
                context.getString(R.string.cat_elderly_link),
                context.getString(R.string.cat_elderly_button),
                context.getString(R.string.elderly_cat_img_desc),
                R.drawable.cat_elderly,
                0, 1, 0, 0, 0, 1, 0);
        catElderly.setPetNeeds();

        pets.add(catElderly);

        Pet puppy = new Pet(
                context.getString(R.string.puppy),
                context.getString(R.string.puppy_desc),
                context.getString(R.string.puppy_link),
                context.getString(R.string.puppy_button),
                context.getString(R.string.puppy_img_desc),
                R.drawable.dog_young,
                2, 2, 2, 2, 1, 1, 2);
        puppy.setPetNeeds();

        pets.add(puppy);

        Pet dogAdult = new Pet(
                context.getString(R.string.dog_adult),
                context.getString(R.string.dog_adult_desc),
                context.getString(R.string.dog_adult_link),
                context.getString(R.string.dog_adult_button),
                context.getString(R.string.dog_img_desc),
                R.drawable.dog_adult,
                1, 2, 2, 2, 0, 1, 2);
        dogAdult.setPetNeeds();

        pets.add(dogAdult);

        Pet dogElderly = new Pet(
                context.getString(R.string.dog_elderly),
                context.getString(R.string.dog_elderly_desc),
                context.getString(R.string.dog_elderly_link),
                context.getString(R.string.dog_elderly_button),
                context.getString(R.string.elderly_dog_img_desc),
                R.drawable.dog_elderly,
                1, 2, 1, 2, 0, 1, 2);
        dogElderly.setPetNeeds();

        pets.add(dogElderly);

        Pet miscPet = new Pet(
                context.getString(R.string.misc_pets),
                context.getString(R.string.misc_pet_desc),
                context.getString(R.string.misc_pet_link),
                context.getString(R.string.misc_pet_button),
                context.getString(R.string.misc_pet_img_desc),
                R.drawable.misc_pets,
                0, 0, 0, 0, 2, 2, 0);
        miscPet.setPetNeeds();

        pets.add(miscPet);

        return pets;
    }
}
