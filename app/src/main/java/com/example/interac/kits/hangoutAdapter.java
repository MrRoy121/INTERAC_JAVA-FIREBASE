package com.example.interac.kits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interac.R;

import java.util.ArrayList;

public class hangoutAdapter  extends RecyclerView.Adapter<hangoutAdapter.ViewHolder>{
    private ArrayList<campusResourseModel> listdata;
    Context context;

    public hangoutAdapter(ArrayList<campusResourseModel> listdata,  Context context) {
        this.listdata = listdata;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.hangouts_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(listdata.get(position).getTitle());
        holder.details.setText(listdata.get(position).getDetails());
        holder.time.setText(listdata.get(position).getTime());
        if(listdata.get(position).getImage()!=null){
            Glide.with(context)
                    .load(listdata.get(position).getImage())
                    .centerCrop()
                    .into(holder.imageView);
        }

//        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
//            }
//        });
    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView title, details, time;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.details = (TextView) itemView.findViewById(R.id.details);
            this.time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}