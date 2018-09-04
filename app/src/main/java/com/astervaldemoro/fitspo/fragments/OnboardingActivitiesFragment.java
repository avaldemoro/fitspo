package com.astervaldemoro.fitspo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.astervaldemoro.fitspo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingActivitiesFragment extends Fragment {
    @BindView (R.id.sedentary_checkbox) CheckBox sedentaryCB;
    @BindView (R.id.light_activity_checkbox) CheckBox lightActivityCB;
    @BindView (R.id.active_checkbox) CheckBox activeCB;
    @BindView (R.id.very_active_checkbox) CheckBox veryActiveCB;
    @BindView (R.id.activity_next_button) Button nextButton;
    @BindView (R.id.activity_previous_button) Button previousButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_activity, container, false);
        ButterKnife.bind(this, view);

        View.OnClickListener clickListener = new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                switch (v.getId ()) {
                    case R.id.sedentary_checkbox:
                        sedentaryCB.setChecked (true);
                        lightActivityCB.setChecked (false);
                        activeCB.setChecked (false);
                        veryActiveCB.setChecked (false);
                        break;
                    case R.id.light_activity_checkbox:
                        sedentaryCB.setChecked (false);
                        lightActivityCB.setChecked (true);
                        activeCB.setChecked (false);
                        veryActiveCB.setChecked (false);
                        break;

                    case R.id.active_checkbox:
                        sedentaryCB.setChecked (false);
                        lightActivityCB.setChecked (false);
                        activeCB.setChecked (true);
                        veryActiveCB.setChecked (false);
                        break;

                    case R.id.very_active_checkbox:
                        sedentaryCB.setChecked (false);
                        lightActivityCB.setChecked (false);
                        activeCB.setChecked (false);
                        veryActiveCB.setChecked (true);
                        break;

                }
            }
        };

        sedentaryCB.setOnClickListener (clickListener);
        lightActivityCB.setOnClickListener (clickListener);
        activeCB.setOnClickListener (clickListener);
        veryActiveCB.setOnClickListener (clickListener);

        nextButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                OnboardingExerciseFragment onboardingExerciseFragment = new OnboardingExerciseFragment ();
                onboardingExerciseFragment.setArguments (bundle);

                getActivity ().getSupportFragmentManager ().beginTransaction ()
                        .replace (R.id.onboarding_frame_container, onboardingExerciseFragment)
                        .commit ();
            }
        });

        previousButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                OnboardingInfoFragment onboardingInfoFragment = new OnboardingInfoFragment ();
                onboardingInfoFragment.setArguments (bundle);

                getActivity ().getSupportFragmentManager ().beginTransaction ()
                        .replace (R.id.onboarding_frame_container, onboardingInfoFragment)
                        .commit ();
            }
        });

        return view;
    }
}
