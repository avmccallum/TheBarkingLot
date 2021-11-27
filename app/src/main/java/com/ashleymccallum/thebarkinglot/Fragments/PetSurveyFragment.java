package com.ashleymccallum.thebarkinglot.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ashleymccallum.thebarkinglot.Pet;
import com.ashleymccallum.thebarkinglot.PetList;
import com.ashleymccallum.thebarkinglot.R;

import java.util.ArrayList;
import java.util.Arrays;

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


    int index = 0;

    int[] answers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pet_survey, container, false);
        ArrayList<Pet> allPets = PetList.initializePets(getContext());

        String[] questions = {getString(R.string.q_hours), getString(R.string.q_grooming), getString(R.string.q_activity), getString(R.string.q_outdoor), getString(R.string.q_enclosure), getString(R.string.q_experience), getString(R.string.q_companion)};
        String[] topOptions = {getString(R.string.a_hours_1), getString(R.string.a_grooming_1), getString(R.string.a_activity_1), getString(R.string.a_outdoor_1), getString(R.string.a_enclosure_1), getString(R.string.a_experience_1), getString(R.string.a_companion_1)};
        String[] middleOptions = {getString(R.string.a_hours_2), getString(R.string.a_grooming_2), getString(R.string.a_activity_2), getString(R.string.a_outdoor_2), getString(R.string.a_enclosure_2), getString(R.string.a_experience_2), getString(R.string.a_companion_2)};
        String[] bottomOptions = {getString(R.string.a_hours_3), getString(R.string.a_grooming_3), getString(R.string.a_activity_3), getString(R.string.a_outdoor_3), getString(R.string.a_enclosure_3), getString(R.string.a_experience_3), getString(R.string.a_companion_3)};

        TextView quizQuestionText = view.findViewById(R.id.quizQuestionText);
        TextView questionCount = view.findViewById(R.id.questionCountText);
        RadioGroup quizGroup = view.findViewById(R.id.quizQuestionGroup);
        RadioButton question1 = view.findViewById(R.id.quizQuestion1);
        RadioButton question2 = view.findViewById(R.id.quizQuestion2);
        RadioButton question3 = view.findViewById(R.id.quizQuestion3);

        //on initial load, set text to first question
        quizQuestionText.setText(questions[index]);
        questionCount.setText("" + (index + 1));
        question1.setText(topOptions[index]);
        question2.setText(middleOptions[index]);
        question3.setText(bottomOptions[index]);
        answers = new int[questions.length];

        Button nextButton = view.findViewById(R.id.quizNextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //add appropriate num to answers array
                if(quizGroup.getCheckedRadioButtonId() == question1.getId()) {
                    answers[index] = 0;
                } else if (quizGroup.getCheckedRadioButtonId() == question2.getId()) {
                    answers[index] = 1;
                } else if (quizGroup.getCheckedRadioButtonId() == question3.getId()) {
                    answers[index] = 2;
                }
                Log.d("__________________", Arrays.toString(answers));

                //clear the checked option in the group
                quizGroup.clearCheck();

                //increase the index
                index++;

                //if the index is in range, change question text to next question
                if(index <= questions.length - 1) {
                    quizQuestionText.setText(questions[index]);
                    questionCount.setText("" + (index + 1));
                    question1.setText(topOptions[index]);
                    question2.setText(middleOptions[index]);
                    question3.setText(bottomOptions[index]);
                }

                //set button text to submit for last question
                if(index == questions.length - 1) {
                    nextButton.setText(getString(R.string.submit_quiz));
                }

                //navigate to result on last question
                if(index == questions.length) {
                    index -= questions.length;
                    Pet searchPet = new Pet(answers);
                    ArrayList<Pet> results = Pet.matchPets(allPets, searchPet);
                    PetList.setResultPets(results);

                    Navigation.findNavController(view).navigate(R.id.action_nav_pet_survey_to_nav_quiz_results);

                    for(Pet pet : results) {
                        Log.d("__________________", pet.getPetName());
                    }

                }

            }
        });
        return view;
    }
}