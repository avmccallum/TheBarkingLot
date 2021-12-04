package com.ashleymccallum.thebarkinglot.HomeViewPager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ashleymccallum.thebarkinglot.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeInfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private int mParam2;
    private int mParam3;
    private int mParam4;

    public HomeInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @param param3 Parameter 3.
     * @param param4 Parameter 4.
     * @return A new instance of fragment HomeInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeInfoFragment newInstance(int param1, int param2, int param3, int param4) {
        HomeInfoFragment fragment = new HomeInfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putInt(ARG_PARAM3, param3);
        args.putInt(ARG_PARAM4, param4);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getInt(ARG_PARAM3);
            mParam4 = getArguments().getInt(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_info, container, false);
        TextView homeInfoTitle = view.findViewById(R.id.homeViewPagerTitle);
        TextView homeInfoText = view.findViewById(R.id.homeViewPagerText);
        Button homeInfoButton = view.findViewById(R.id.homeInfoButton);
        if(mParam1 > 0 && mParam2 > 0 && mParam3 > 0 && mParam4 > 0) {
            homeInfoTitle.setText(getString(mParam1));
            homeInfoText.setText(getString(mParam2));
            homeInfoButton.setText(getString(mParam3));
            homeInfoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri website = Uri.parse(getString(mParam4));
                    Intent i = new Intent(Intent.ACTION_VIEW, website);
                    try {
                        getContext().startActivity(i);
                    } catch (ActivityNotFoundException e) {
                        Snackbar.make(getActivity().findViewById(android.R.id.content), "No application found", Snackbar.LENGTH_SHORT).show();
                    }
                }
            });
        }
        return view;
    }
}