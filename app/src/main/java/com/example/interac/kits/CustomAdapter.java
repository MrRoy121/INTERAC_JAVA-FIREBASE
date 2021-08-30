package com.example.interac.kits;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.interac.ConnectPeopleResults;
import com.example.interac.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,nname,phone,email,about;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.nname = (TextView) itemView.findViewById(R.id.nname);
            this.phone = itemView.findViewById(R.id.phone);
            this.email = itemView.findViewById(R.id.email);
            this.about = itemView.findViewById(R.id.about);
        }
    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_cards_layout, parent, false);

        //view.setOnClickListener(ConnectPeopleResults.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        holder.name.setText(dataSet.get(listPosition).name);
        holder.nname.setText(dataSet.get(listPosition).nname);
        holder.phone.setText(dataSet.get(listPosition).phone);
        holder.email.setText(dataSet.get(listPosition).email);
        holder.about.setText(dataSet.get(listPosition).about);

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}