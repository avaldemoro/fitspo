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
import android.widget.RadioGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.astervaldemoro.fitspo.R;
import com.astervaldemoro.fitspo.model.UserInfo;
import com.astervaldemoro.fitspo.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OnboardingInfoFragment extends Fragment {
    UserInfo currentUser;
    @BindView (R.id.height_in_textbox) EditText inchET;
    @BindView (R.id.height_ft_textbox) EditText feetET;
    @BindView (R.id.year_textbox) EditText yearsET;
    @BindView (R.id.man_radiobutton) RadioButton manRB;
    @BindView (R.id.woman_radiobutton) RadioButton womanRB;
    @BindView (R.id.current_weight_textbox) EditText currentWeightET;
    @BindView (R.id.goal_weight_textbox) EditText goalWeightET;
    @BindView (R.id.info_next_button) Button nextButton;
    @BindView (R.id.gender_radiogroup) RadioGroup genderRG;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        if (savedInstanceState != null) {
            currentUser = getArguments().getParcelable (Constant.USER_INFO);

            // TODO: Fix this - edit text should show already entered info
            feetET.setText(currentUser.getFtHeight (), TextView.BufferType.EDITABLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.fragment_onboarding_info, container, false);
        ButterKnife.bind(this, view);

        currentUser = new UserInfo ();

        // Keyboard doesn't automatically show up on creation
        getActivity ().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        genderRG.setOnCheckedChangeListener (new RadioGroup.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(manRB.isChecked ()) {
                    currentUser.setGender (Constant.MALE);
                } else {
                    currentUser.setGender (Constant.FEMALE);
                }
            }
        });



        // Next Button leads to onboarding activity levels
        nextButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                final String heightFeetValue = feetET.getText().toString ();
                final String heightInchValue = inchET.getText ().toString ();

                if (!heightFeetValue.isEmpty ()) {
                    currentUser.setFtHeight (Integer.parseInt (heightFeetValue));
                }
                if (!heightInchValue.isEmpty ()) {
                    currentUser.setInHeight (Integer.parseInt (heightInchValue));
                }
                if (!yearsET.getText ().toString ().isEmpty ()) {
                    currentUser.setAge (Integer.parseInt (yearsET.getText ().toString ()));
                }
                if (!goalWeightET.getText ().toString ().isEmpty ()) {
                    currentUser.setGoalWeight (Integer.parseInt (goalWeightET.getText ().toString ()));
                }
                if (!currentWeightET.getText ().toString ().isEmpty ()) {
                    currentUser.setCurrentWeight (Integer.parseInt (goalWeightET.getText ().toString ()));
                }

                Bundle bundle = new Bundle();
                bundle.putParcelable (Constant.USER_INFO, currentUser);
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
