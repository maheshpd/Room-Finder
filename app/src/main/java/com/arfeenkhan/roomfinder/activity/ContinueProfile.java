package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.arfeenkhan.roomfinder.R;

public class ContinueProfile extends AppCompatActivity implements View.OnClickListener {

    //Widget
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_profile);

        //initialize
        initWidget();
    }

    private void initWidget() {
        updateBtn = findViewById(R.id.updateBtn);

        updateBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.updateBtn){
            Intent intent = new Intent(ContinueProfile.this, Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
