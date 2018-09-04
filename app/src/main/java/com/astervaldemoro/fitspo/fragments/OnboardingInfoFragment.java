package com.astervaldemoro.fitspo.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.astervaldemoro.fitspo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingInfoFragment extends Fragment {
    @BindView (R.id.height_in_textbox) EditText inchET;
    @BindView (R.id.height_ft_textbox) EditText heightET;
    @BindView (R.id.year_textbox) EditText yearsET;
    @BindView (R.id.man_radiobutton) RadioButton manRB;
    @BindView (R.id.woman_radiobutton) RadioButton womanRB;
    @BindView (R.id.current_weight_textbox) EditText currentWeightET;
    @BindView (R.id.goal_weight_textbox) EditText goalWeightET;
    @BindView (R.id.info_next_button) Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_info, container, false);
        ButterKnife.bind(this, view);

        getActivity ().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        nextButton.setOnClickListener (new View.OnClickListener () {
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

        return view;
    }
}
