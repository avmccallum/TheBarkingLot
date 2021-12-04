package com.ashleymccallum.thebarkinglot.Fragments;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.ashleymccallum.thebarkinglot.HomeViewPager.HomeViewPagerAdapter;
import com.ashleymccallum.thebarkinglot.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager2 viewPager2 = view.findViewById(R.id.homeInfoViewPager);
        viewPager2.setAdapter(new HomeViewPagerAdapter(getActivity()));

        //facebook logo directs user to facebook page
        ImageView facebook = view.findViewById(R.id.facebookLogo);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri facebookLink = Uri.parse("https://www.facebook.com/StClairCollege");
                Intent i = new Intent(Intent.ACTION_VIEW, facebookLink);
                try {
                    getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        //twitter logo directs user to twitter page
        ImageView twitter = view.findViewById(R.id.twitterLogo);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri twitterLink = Uri.parse("https://twitter.com/StClairCollege");
                Intent i = new Intent(Intent.ACTION_VIEW, twitterLink);
                try {
                    getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        //instagram logo directs user to instagram page
        ImageView instagram = view.findViewById(R.id.instagramLogo);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri instagramLink = Uri.parse("https://www.instagram.com/stclaircollege/?hl=en");
                Intent i = new Intent(Intent.ACTION_VIEW, instagramLink);
                try {
                    getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        //website logo directs user to website
        ImageView website = view.findViewById(R.id.websiteLogo);
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri websiteLink = Uri.parse("https://www.stclaircollege.ca/");
                Intent i = new Intent(Intent.ACTION_VIEW, websiteLink);
                try {
                    getContext().startActivity(i);
                } catch (ActivityNotFoundException e) {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}