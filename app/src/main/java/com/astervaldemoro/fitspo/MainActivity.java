package com.astervaldemoro.fitspo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.astervaldemoro.fitspo.utils.Constant;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView (R.id.add_meal_fab_main) FloatingActionButton mainAddMealFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        ButterKnife.bind(this);

        mainAddMealFab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this, AddMealsActivity.class);
                startActivity(intent);
            }
        });
    }
}
