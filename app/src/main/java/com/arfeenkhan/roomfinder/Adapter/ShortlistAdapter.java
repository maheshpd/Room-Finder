package com.arfeenkhan.roomfinder.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.arfeenkhan.roomfinder.R;
import com.arfeenkhan.roomfinder.model.ShortlistModel;

import java.util.ArrayList;

public class ShortlistAdapter extends RecyclerView.Adapter<ShortlistAdapter.MyShortListView> {

    Context context;
    ArrayList<ShortlistModel> shortlistlist;

    public ShortlistAdapter(Context context, ArrayList<ShortlistModel> shortlistlist) {
        this.context = context;
        this.shortlistlist = shortlistlist;
    }

    @NonNull
    @Override
    public MyShortListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MyShortListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyShortListView holder, final int position) {
        ShortlistModel shortlistModel = shortlistlist.get(position);

           holder.buildingname.setText(shortlistModel.getBuildingname());
           holder.availableornot.setText(shortlistModel.getAvailable());
           holder.buildingtype.setText(shortlistModel.getBuidlingtype() +"\n Apartment");
           holder.roomrate.setText("\u20B9 " +shortlistModel.getBedrate() + new StringBuilder("/ Bed"));

           holder.book_btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Toast.makeText(context, shortlistlist.get(position).getBedrate(), Toast.LENGTH_SHORT).show();
               }
           });

    }

    @Override
    public int getItemCount() {
        return shortlistlist.size();
    }

    public class MyShortListView extends RecyclerView.ViewHolder {
        //Widget
        ImageView shareImage,likeimage,building_image;
        Button viewDetail_btn,book_btn;
        TextView buildingname,buildingtype,availableornot,roomrate;

        public MyShortListView(@NonNull View itemView) {
            super(itemView);

            shareImage = itemView.findViewById(R.id.shareimg);
            likeimage = itemView.findViewById(R.id.likeimg);
            building_image = itemView.findViewById(R.id.roomimg);
            viewDetail_btn = itemView.findViewById(R.id.view_details);
            book_btn = itemView.findViewById(R.id.booknow);
            buildingname = itemView.findViewById(R.id.buildingname);
            buildingtype = itemView.findViewById(R.id.roomtype);
            availableornot = itemView.findViewById(R.id.available);
            roomrate = itemView.findViewById(R.id.bedrate);

        }
    }
}
