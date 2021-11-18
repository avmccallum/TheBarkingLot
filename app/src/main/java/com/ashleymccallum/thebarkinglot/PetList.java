package com.ashleymccallum.thebarkinglot;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PetList {

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
                PetRequirement.MODERATE,
                PetRequirement.MODERATE,
                PetRequirement.MODERATE,
                PetRequirement.MINIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MAXIMUM);

        pets.add(kitten);

        Pet catAdult = new Pet(
                context.getString(R.string.cat_adult),
                context.getString(R.string.cat_adult_desc),
                context.getString(R.string.cat_adult_link),
                context.getString(R.string.cat_adult_button),
                context.getString(R.string.cat_img_desc),
                R.drawable.cat_adult,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MODERATE,
                PetRequirement.MODERATE);

        pets.add(catAdult);

        Pet catElderly = new Pet(
                context.getString(R.string.cat_elderly),
                context.getString(R.string.cat_elderly_desc),
                context.getString(R.string.cat_elderly_link),
                context.getString(R.string.cat_elderly_button),
                context.getString(R.string.elderly_cat_img_desc),
                R.drawable.cat_elderly,
                PetRequirement.MINIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MINIMUM);

        pets.add(catElderly);

        Pet puppy = new Pet(
                context.getString(R.string.puppy),
                context.getString(R.string.puppy_desc),
                context.getString(R.string.puppy_link),
                context.getString(R.string.puppy_button),
                context.getString(R.string.puppy_img_desc),
                R.drawable.dog_young,
                PetRequirement.MAXIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MODERATE,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM);

        pets.add(puppy);

        Pet dogAdult = new Pet(
                context.getString(R.string.dog_adult),
                context.getString(R.string.dog_adult_desc),
                context.getString(R.string.dog_adult_link),
                context.getString(R.string.dog_adult_button),
                context.getString(R.string.dog_img_desc),
                R.drawable.dog_adult,
                PetRequirement.MAXIMUM,
                PetRequirement.MODERATE,
                PetRequirement.MINIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MODERATE);

        pets.add(dogAdult);

        Pet dogElderly = new Pet(
                context.getString(R.string.dog_elderly),
                context.getString(R.string.dog_elderly_desc),
                context.getString(R.string.dog_elderly_link),
                context.getString(R.string.dog_elderly_button),
                context.getString(R.string.elderly_dog_img_desc),
                R.drawable.dog_elderly,
                PetRequirement.MODERATE,
                PetRequirement.MODERATE,
                PetRequirement.MINIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MODERATE);

        pets.add(dogElderly);

        Pet miscPet = new Pet(
                context.getString(R.string.misc_pets),
                context.getString(R.string.misc_pet_desc),
                context.getString(R.string.misc_pet_link),
                context.getString(R.string.misc_pet_button),
                context.getString(R.string.misc_pet_img_desc),
                R.drawable.misc_pets,
                PetRequirement.MINIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MAXIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM,
                PetRequirement.MINIMUM);

        pets.add(miscPet);

        return pets;
    }
}
