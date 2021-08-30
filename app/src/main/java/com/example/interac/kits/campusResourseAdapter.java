package com.example.interac.kits;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.interac.R;

import java.util.ArrayList;


public class campusResourseAdapter extends RecyclerView.Adapter<campusResourseAdapter.ViewHolder>{
    private ArrayList<campusResourseModel> listdata;
    Context context;

    public campusResourseAdapter(ArrayList<campusResourseModel> listdata,  Context context) {
        this.listdata = listdata;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.campus_resourse_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(listdata.get(position).getTitle());
        holder.details.setText(listdata.get(position).getDetails());
        holder.com.setText(listdata.get(position).getCom());
        holder.con.setText(listdata.get(position).getCon());
        holder.tsf.setText(listdata.get(position).getTfs());
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
        public TextView title, details, com, con, tsf, time;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (ImageView) itemView.findViewById(R.id.image);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.details = (TextView) itemView.findViewById(R.id.details);
            this.com = (TextView) itemView.findViewById(R.id.com);
            this.con = (TextView) itemView.findViewById(R.id.con);
            this.tsf = (TextView) itemView.findViewById(R.id.tsf);
            this.time = (TextView) itemView.findViewById(R.id.time);
        }
    }
}