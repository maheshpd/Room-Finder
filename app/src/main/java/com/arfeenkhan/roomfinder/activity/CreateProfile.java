package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.arfeenkhan.roomfinder.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class CreateProfile extends AppCompatActivity implements View.OnClickListener {

    //Widget
    Button btn_continue,edtPhoto;
    private LinearLayout profile_bottomsheet;
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

//        initializer

        initWidget();
    }

    private void initWidget() {
        btn_continue = findViewById(R.id.btn_continue);
        edtPhoto = findViewById(R.id.edtPhoto);

//        profile_bottomsheet = findViewById(R.id.profile_bottomsh);
//        bottomSheetBehavior = BottomSheetBehavior.from(profile_bottomsheet);
//        //state hidden
//        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);


        //on Button click
        btn_continue.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_continue) {
            Intent intent = new Intent(CreateProfile.this, ContinueProfile.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (id == R.id.edtPhoto) {
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
