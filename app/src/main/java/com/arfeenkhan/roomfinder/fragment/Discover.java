package com.arfeenkhan.roomfinder.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.activity.Filter;
import com.arfeenkhan.roomfinder.activity.ForgotPassword;
import com.arfeenkhan.roomfinder.activity.Login;

/**
 * A simple {@link Fragment} subclass.
 */
public class Discover extends Fragment {

    //widget
    LinearLayout filter_layout,short_layout;
    Dialog short_dialog;
    ImageButton cancel_btn;

    public Discover() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

//        initializer
        filter_layout = view.findViewById(R.id.filter_btn);
        short_layout = view.findViewById(R.id.short_layout);

        short_dialog = new Dialog(view.getContext());

        initWidet();
        return view;
    }

    private void initWidet() {

        filter_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Filter.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        short_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                short_dialog.setContentView(R.layout.short_layout);
                short_dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                //init short dialog widget
                cancel_btn = short_dialog.findViewById(R.id.cancel_btn);


                cancel_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        short_dialog.dismiss();
                    }
                });
                short_dialog.show();
            }
        });
    }

}
