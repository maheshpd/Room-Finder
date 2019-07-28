package com.arfeenkhan.roomfinder.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.activity.Filter;
import com.arfeenkhan.roomfinder.activity.ForgotPassword;
import com.arfeenkhan.roomfinder.activity.Login;

/**
 * A simple {@link Fragment} subclass.
 */
public class Discover extends Fragment {

    LinearLayout filter_layout;

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
    }

}
