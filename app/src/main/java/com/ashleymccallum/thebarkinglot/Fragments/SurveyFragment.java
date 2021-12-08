package com.ashleymccallum.thebarkinglot.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ashleymccallum.thebarkinglot.R;
import com.ashleymccallum.thebarkinglot.SurveyViewPager.SurveyViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SurveyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SurveyFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public SurveyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SurveyFragment.
     */
    public static SurveyFragment newInstance(String param1, String param2) {
        SurveyFragment fragment = new SurveyFragment();
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

    Timer timer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_survey, container, false);

        ViewPager2 viewPager2 = view.findViewById(R.id.petSlideShow);
        viewPager2.setAdapter(new SurveyViewPagerAdapter(getActivity()));

        //viewpager does not allow user to scroll
        viewPager2.setUserInputEnabled(false);
        viewPager2.setPageTransformer(new SurveyViewPagerAdapter(getActivity()));

        //imageCount is the total number of ImageFragments
        int imageCount = viewPager2.getAdapter().getItemCount();

        //timerTask changes the ImageFragment to the next item
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                viewPager2.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager2.setCurrentItem((viewPager2.getCurrentItem() + 1), false);
                        if (viewPager2.getCurrentItem() == imageCount - 1) {
                            viewPager2.setCurrentItem(0, false);
                        }
                    }
                });
            }
        };

        //timer controls the speed of the timerTask
        timer = new Timer();
        timer.schedule(timerTask, 3000, 3000);

        //Button navigates to beginning of quiz
        Button beginButton = view.findViewById(R.id.quizButton);
        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_survey_to_petSurveyFragment);
            }
        });
        return view;
    }
}