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

import java.util.List;

public class uploadImageAdapter extends RecyclerView.Adapter<uploadImageAdapter.ViewHolder> {

    Context context;
    List<imageModel> MainImageUploadInfoList;

    public uploadImageAdapter(Context context, List<imageModel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        imageModel UploadInfo = MainImageUploadInfoList.get(position);
        holder.name.setText(UploadInfo.name);
        Glide.with(context).load(UploadInfo.imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
