package com.arfeenkhan.roomfinder.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.fragment.Discover;
import com.arfeenkhan.roomfinder.fragment.Notification;
import com.arfeenkhan.roomfinder.fragment.Profile;
import com.arfeenkhan.roomfinder.fragment.Shortlist;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    //Widget
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //inializer
        initWidget();
        bottomNavigationView.setSelectedItemId(R.id.dsicover_menu);

    }


    private void initWidget() {
        //init widget
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            Fragment fragment = null;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.dsicover_menu)
                    fragment = new Discover();
                else if (menuItem.getItemId() == R.id.shortlist_menu)
                    fragment = new Shortlist();
                else if (menuItem.getItemId() == R.id.notification_menu)
                    fragment = new Notification();
                else if (menuItem.getItemId() == R.id.profile_menu)
                    fragment = new Profile();

                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, fragment).commit();
            return true;

        }
        return false;
    }
}
