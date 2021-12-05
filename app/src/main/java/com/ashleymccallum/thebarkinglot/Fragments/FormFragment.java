package com.ashleymccallum.thebarkinglot.Fragments;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ashleymccallum.thebarkinglot.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FormFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public FormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FormFragment.
     */
    public static FormFragment newInstance(String param1, String param2) {
        FormFragment fragment = new FormFragment();
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
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
//        String phoneNumber = sharedPreferences.getString("userPhone", "");

        EditText fname = view.findViewById(R.id.fnameField);
        fname.setText(sharedPreferences.getString("userFirstName", ""));

        EditText lname = view.findViewById(R.id.lnameField);
        lname.setText(sharedPreferences.getString("userLastName", ""));

        EditText email = view.findViewById(R.id.emailField);
        email.setText(sharedPreferences.getString("userEmail", ""));

        EditText phone = view.findViewById(R.id.phoneField);
        phone.setText(sharedPreferences.getString("userPhone", "").replaceAll("[^\\d]", ""));

        EditText petType = view.findViewById(R.id.petTypeField);
        EditText experience = view.findViewById(R.id.experienceField);

        Button formSubmit = view.findViewById(R.id.formSubmit);
        formSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //body of email retrieved from edittext fields
                String body = "First Name: " + fname.getText() + "\n\n" +
                        "Last Name: " + lname.getText() + "\n\n" +
                        "Email Address: " + email.getText() + "\n\n" +
                        "Phone: " + phone.getText() + "\n\n" +
                        "Preferred Foster Animal(s): " + petType.getText() + "\n\n" +
                        "Fostering Experience: " + experience.getText() + "\n\n";

                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, new String[] {"contact@thebarkinglot.ca"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Foster Application: " + fname.getText() + " " + lname.getText());
                i.putExtra(Intent.EXTRA_TEXT, body);
                try {
                    startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}