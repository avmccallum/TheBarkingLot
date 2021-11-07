package com.ashleymccallum.thebarkinglot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashleymccallum.thebarkinglot.RecyclerView.CustomRecyclerViewAdapter;
import com.ashleymccallum.thebarkinglot.RecyclerView.PetInfo;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PetInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PetInfoFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PetInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PetInfoFragment.
     */
    public static PetInfoFragment newInstance(String param1, String param2) {
        PetInfoFragment fragment = new PetInfoFragment();
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
        View view = inflater.inflate(R.layout.fragment_pet_info, container, false);
        ArrayList<PetInfo> pets = new ArrayList<>();
        pets.add(new PetInfo(getString(R.string.kitten), R.drawable.cat_young, getString(R.string.kitten_desc), getString(R.string.kitten_link), getString(R.string.kitten_button)));
        pets.add(new PetInfo(getString(R.string.cat_adult), R.drawable.cat_adult, getString(R.string.cat_adult_desc), getString(R.string.cat_adult_link), getString(R.string.cat_adult_button)));
        pets.add(new PetInfo(getString(R.string.cat_elderly), R.drawable.cat_elderly, getString(R.string.cat_elderly_desc), getString(R.string.cat_elderly_link), getString(R.string.cat_elderly_button)));
        pets.add(new PetInfo(getString(R.string.puppy), R.drawable.dog_young, getString(R.string.puppy_desc), getString(R.string.puppy_link), getString(R.string.puppy_button)));
        pets.add(new PetInfo(getString(R.string.dog_adult), R.drawable.dog_adult, getString(R.string.dog_adult_desc), getString(R.string.dog_adult_link), getString(R.string.dog_adult_button)));
        pets.add(new PetInfo(getString(R.string.dog_elderly), R.drawable.dog_elderly, getString(R.string.dog_elderly_desc), getString(R.string.dog_elderly_link), getString(R.string.dog_elderly_button)));
        pets.add(new PetInfo(getString(R.string.misc_pets), R.drawable.misc_pets, getString(R.string.misc_pet_desc), getString(R.string.misc_pet_link), getString(R.string.misc_pet_button)));
        RecyclerView petInfoRecycler = view.findViewById(R.id.petInfoRecycler);
        petInfoRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        petInfoRecycler.setAdapter(new CustomRecyclerViewAdapter(pets));
        return view;
    }
}