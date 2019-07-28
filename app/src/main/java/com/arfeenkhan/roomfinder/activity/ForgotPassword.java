package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.arfeenkhan.roomfinder.R;

public class ForgotPassword extends AppCompatActivity implements View.OnClickListener {

    ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        //init Widget
        initWidget();
    }

    private void initWidget() {
        backBtn = findViewById(R.id.forgot_backBtn);

//        on Btn Click
        backBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.forgot_backBtn) {
            finish();
        }
    }
}
