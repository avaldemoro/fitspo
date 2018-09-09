package com.astervaldemoro.fitspo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.astervaldemoro.fitspo.AddMealsActivity;
import com.astervaldemoro.fitspo.MainActivity;
import com.astervaldemoro.fitspo.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingResultFragment extends Fragment {
    @BindView (R.id.results_calories_textview) TextView resultsCaloriesTV;
    @BindView (R.id.results_carbs_textview) TextView resultsCarbsTV;
    @BindView (R.id.results_fats_textview) TextView resultsFatsTV;
    @BindView (R.id.results_protien_textview) TextView resultsProtienTV;
    @BindView (R.id.results_next_button) Button nextButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_results, container, false);
        ButterKnife.bind (this, view);

        nextButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getActivity ().getApplicationContext (), MainActivity.class);
                getActivity ().startActivity(intent);
            }
        });

        return view;
    }
}
