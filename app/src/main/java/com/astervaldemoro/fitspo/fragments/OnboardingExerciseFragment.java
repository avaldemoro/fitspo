package com.astervaldemoro.fitspo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.astervaldemoro.fitspo.R;
import com.astervaldemoro.fitspo.model.UserInfo;
import com.astervaldemoro.fitspo.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingExerciseFragment extends Fragment {
    UserInfo currentUser;
    @BindView (R.id.exercise_next_button) Button nextButton;
    @BindView (R.id.exercise_previous_button) Button previousButton;
    @BindView (R.id.days_textbox) EditText daysET;
    @BindView (R.id.minutes_textbox) EditText minutesET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        currentUser = getArguments().getParcelable (Constant.USER_INFO);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_exercise, container, false);
        ButterKnife.bind(this, view);

        getActivity ().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        previousButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                OnboardingActivitiesFragment onboardingActivitiesFragment = new OnboardingActivitiesFragment ();
                onboardingActivitiesFragment.setArguments (bundle);

                getActivity ().getSupportFragmentManager ().beginTransaction ()
                        .replace (R.id.onboarding_frame_container, onboardingActivitiesFragment)
                        .commit ();
            }
        });

        nextButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (!daysET.getText ().toString ().isEmpty ()) {
                    currentUser.setDaysPerWeekExercise (Integer.parseInt (daysET.getText ().toString ()));
                }
                if (!minutesET.getText ().toString ().isEmpty ()) {
                    currentUser.setMinutesPerDayExercise (Integer.parseInt (daysET.getText ().toString ()));
                }

                Bundle bundle = new Bundle();
                bundle.putParcelable (Constant.USER_INFO, currentUser);
                OnboardingGoalFragment onboardingGoalFragment = new OnboardingGoalFragment ();
                onboardingGoalFragment.setArguments (bundle);

                getActivity ().getSupportFragmentManager ().beginTransaction ()
                        .replace (R.id.onboarding_frame_container, onboardingGoalFragment)
                        .commit ();
            }
        });

        return view;
    }
}
