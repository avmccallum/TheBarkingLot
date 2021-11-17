package com.ashleymccallum.thebarkinglot.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ashleymccallum.thebarkinglot.Pet;
import com.ashleymccallum.thebarkinglot.PetList;
import com.ashleymccallum.thebarkinglot.PetRequirement;
import com.ashleymccallum.thebarkinglot.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetSurveyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetSurveyFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PetSurveyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetSurveyFragment.
     */
    public static PetSurveyFragment newInstance(String param1, String param2) {
        PetSurveyFragment fragment = new PetSurveyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet_survey, container, false);

        ArrayList<Pet> allPets = PetList.addAllPets(getContext());

        Map<String, String> testMap = new HashMap<>();
        testMap.put("activityLevel", PetRequirement.MINIMUM.toString());
        testMap.put("experienceRequired", PetRequirement.MAXIMUM.toString());
        testMap.put("enclosureRequired", PetRequirement.MAXIMUM.toString());
        testMap.put("outdoorRequired", PetRequirement.MINIMUM.toString());
        testMap.put("companionType", PetRequirement.MINIMUM.toString());
        testMap.put("groomingNeed", PetRequirement.MINIMUM.toString());
        Pet testPet = new Pet(testMap, 0, 5);


        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Pet> testList = Pet.matchPets(allPets, testPet);
                Log.d("TEST", String.valueOf(testList.get(0).getProperty("petName")));

                Navigation.findNavController(view).navigate(R.id.action_nav_pet_survey_to_nav_quiz_results);
            }
        });
        return view;
    }
}