package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.arfeenkhan.roomfinder.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class Home extends AppCompatActivity {

    //Widget
    BottomNavigationItemView bottomNavigationItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //inializer
        initWidget();
    }

    private void initWidget() {
        //init widget
        bottomNavigationItemView = findViewById(R.id.bottomNavigationView);

//        bottomNavigationItemView.setOn
    }
}
