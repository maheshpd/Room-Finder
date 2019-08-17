package com.arfeenkhan.roomfinder.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.activity.Filter;
import com.arfeenkhan.roomfinder.activity.ForgotPassword;
import com.arfeenkhan.roomfinder.activity.Login;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class Discover extends Fragment {

    //widget
    LinearLayout filter_layout,short_layout,map_line;
    Dialog short_dialog;
    ImageButton cancel_btn;

    //static Latitude and longitude

    Double latitude = 19.376204;
    Double longitude = 72.866381;
    Geocoder geocoder;
    List<Address> addresses;

    boolean isMap=false;
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
        map_line = view.findViewById(R.id.map_line);

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

        geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocation(latitude,longitude,1);
            String address = addresses.get(0).getAddressLine(0);
            String area = addresses.get(0).getLocality();
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryName();
            String postalcode = addresses.get(0).getPostalCode();

            Toast.makeText(getContext(), postalcode, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), address, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), area, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), city, Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), country, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    private boolean loadFragment(Fragment fragment) {
//        if (fragment != null) {
//            FragmentManager.beginTransaction().replace(R.id.home_fragment_container, fragment).commit();
//            return true;
//
//        }
//        return false;
//    }

}
