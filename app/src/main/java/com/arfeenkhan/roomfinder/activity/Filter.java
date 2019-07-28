package com.arfeenkhan.roomfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.arfeenkhan.roomfinder.R;

public class Filter extends AppCompatActivity implements View.OnClickListener {

    //widget
    ImageButton bkcBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        //initializer
        initWidget();

    }

    private void initWidget() {
        bkcBtn = findViewById(R.id.filter_backbtn);

        bkcBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id==R.id.filter_backbtn){
            finish();
        }
    }
}
