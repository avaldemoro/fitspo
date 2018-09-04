package com.astervaldemoro.fitspo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddMealsActivity extends AppCompatActivity {
    @BindView (R.id.my_toolbar) android.support.v7.widget.Toolbar mainTB;
    @BindView (R.id.meal_name_textbox) EditText mealNameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_meals);
        ButterKnife.bind(this);

        // Up button
        setSupportActionBar(mainTB);
        android.support.v7.app.ActionBar actionBar = this.getSupportActionBar ();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled (true);
        }

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



    }
}
