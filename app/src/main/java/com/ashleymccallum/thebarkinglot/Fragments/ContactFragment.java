package com.ashleymccallum.thebarkinglot.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ashleymccallum.thebarkinglot.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContactFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ContactFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContactFragment.
     */
    public static ContactFragment newInstance(String param1, String param2) {
        ContactFragment fragment = new ContactFragment();
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        Button phoneButton = view.findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5191234567"));
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button emailButton = view.findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, new String[] {"contact@thebarkinglot.ca"});
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        Button mapButton = view.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse("geo:0,0?q=42.271614841603736,-82.92161566608964(The Barking Lot)");
                //TODO - label not working for map location
                Intent i = new Intent(Intent.ACTION_VIEW, location);
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        Button formButton = view.findViewById(R.id.formButton);
        formButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_contact_to_nav_form);
            }
        });
        return view;
    }
}