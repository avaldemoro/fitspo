package com.astervaldemoro.fitspo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.astervaldemoro.fitspo.MainActivity;
import com.astervaldemoro.fitspo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingGoalFragment extends Fragment {
    @BindView (R.id.results_button) Button resultsButton;
    @BindView (R.id.loss_suggested_checkbox) CheckBox lossSuggestedCB;
    @BindView (R.id.loss_aggressive_checkbox) CheckBox lossAggressiveCB;
    @BindView (R.id.loss_reckless_checkbox) CheckBox lossRecklessCB;
    @BindView (R.id.maintenance_suggested_checkbox) CheckBox mainSuggestedCB;
    @BindView (R.id.bulking_cautious_checkbox) CheckBox bulkingCautiousCB;
    @BindView (R.id.bulking_textbook_checkbox) CheckBox bulkingTextbookCB;
    @BindView (R.id.bulking_aggressive_checkbox) CheckBox bulkingAggressiveCB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_goals, container, false);
        ButterKnife.bind(this, view);

        // TODO: Make this code more DRY
        View.OnClickListener clickListener = new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                switch (v.getId ()) {
                    case R.id.loss_suggested_checkbox:
                        lossSuggestedCB.setChecked (true);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.loss_aggressive_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (true);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.loss_reckless_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (true);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.maintenance_suggested_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (true);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.bulking_cautious_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (true);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.bulking_aggressive_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (true);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (false);
                        break;
                    case R.id.bulking_textbook_checkbox:
                        lossSuggestedCB.setChecked (false);
                        lossAggressiveCB.setChecked (false);
                        lossRecklessCB.setChecked (false);
                        mainSuggestedCB.setChecked (false);
                        bulkingAggressiveCB.setChecked (false);
                        bulkingCautiousCB.setChecked (false);
                        bulkingTextbookCB.setChecked (true);
                        break;

                }
            }
        };

        lossSuggestedCB.setOnClickListener (clickListener);
        lossAggressiveCB.setOnClickListener (clickListener);
        lossRecklessCB.setOnClickListener (clickListener);
        mainSuggestedCB.setOnClickListener (clickListener);
        bulkingAggressiveCB.setOnClickListener (clickListener);
        bulkingCautiousCB.setOnClickListener (clickListener);
        bulkingTextbookCB.setOnClickListener (clickListener);

        resultsButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                OnboardingResultFragment onboardingResultFragment = new OnboardingResultFragment ();
                onboardingResultFragment.setArguments (bundle);

                getActivity ().getSupportFragmentManager ().beginTransaction ()
                        .replace (R.id.onboarding_frame_container, onboardingResultFragment)
                        .commit ();
            }
        });

        return view;
    }
}
