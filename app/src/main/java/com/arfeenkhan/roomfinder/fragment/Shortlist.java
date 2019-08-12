package com.arfeenkhan.roomfinder.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arfeenkhan.roomfinder.Adapter.ShortlistAdapter;
import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.model.ShortlistModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shortlist extends Fragment {


    //Widget
    RecyclerView myshortlist_recycler_view;

    //ArrayLisy
    ArrayList<ShortlistModel> shortlistModelArrayList;
    ShortlistAdapter adapter;
    LinearLayoutManager manager;
    public Shortlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemview = inflater.inflate(R.layout.fragment_shortlist, container, false);

        shortlistModelArrayList = new ArrayList<>();
        shortlistModelArrayList.add(new ShortlistModel(R.drawable.girls,"Abc","1 BHK","Available","2000"));
        shortlistModelArrayList.add(new ShortlistModel(R.drawable.girls,"Def","2 BHK","Not Available","4000"));
        shortlistModelArrayList.add(new ShortlistModel(R.drawable.girls,"ghi","3 BHK","Available","5000"));
        shortlistModelArrayList.add(new ShortlistModel(R.drawable.girls,"Jkl","4 BHK","Not Available","6000"));

        //initWidget
        myshortlist_recycler_view=itemview.findViewById(R.id.my_short_list_recyclerview);
        adapter = new ShortlistAdapter(getContext(),shortlistModelArrayList);
        manager = new LinearLayoutManager(getContext());
        myshortlist_recycler_view.setLayoutManager(manager);
        myshortlist_recycler_view.setItemAnimator(new DefaultItemAnimator());
        myshortlist_recycler_view.setHasFixedSize(true);
        myshortlist_recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return itemview;
    }



}
