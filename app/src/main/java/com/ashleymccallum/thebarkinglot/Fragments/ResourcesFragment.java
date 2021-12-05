package com.ashleymccallum.thebarkinglot.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ashleymccallum.thebarkinglot.ListView.CustomListViewAdapter;
import com.ashleymccallum.thebarkinglot.ListView.Resource;
import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResourcesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResourcesFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ResourcesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResourcesFragment.
     */
    public static ResourcesFragment newInstance(String param1, String param2) {
        ResourcesFragment fragment = new ResourcesFragment();
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
        View view = inflater.inflate(R.layout.fragment_resources, container, false);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        String petToggle = sharedPreferences.getString("petMenu", "pet");

        ListView resourceList = view.findViewById(R.id.resourceList);
        ArrayList<Resource> resources = new ArrayList<>();
        resources.add(new Resource(getString(R.string.resource6), R.drawable.ic_launcher_foreground));
        resources.add(new Resource(getString(R.string.resource1), R.drawable.ic_launcher_foreground, getString(R.string.resourceLink1)));
        resources.add(new Resource(getString(R.string.resource2), R.drawable.ic_launcher_foreground, getString(R.string.resourceLink2)));
        resources.add(new Resource(getString(R.string.resource3), R.drawable.ic_launcher_foreground, getString(R.string.resourceLink3)));
        resources.add(new Resource(getString(R.string.resource4), R.drawable.ic_launcher_foreground, petToggle + getString(R.string.resourceLink4)));
        resources.add(new Resource(getString(R.string.resource5), R.drawable.ic_launcher_foreground, petToggle + getString(R.string.resourceLink5)));
        resourceList.setAdapter(new CustomListViewAdapter(getContext(), resources));
        return view;
    }
}