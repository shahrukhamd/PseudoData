package com.sasiddiqui.pseudodata.presentation.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.network.model.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shahrukhamd on 19/05/18.
 */
public class PhotosRVAdapter extends RecyclerView.Adapter<PhotosRVAdapter.ViewHolder> {

    private List<Photo> photoList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.photo_list_item_image)
        ImageView imageView;
        @BindView(R.id.photo_list_item_title)
        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindData(Photo photo) {
            textView.setText(photo.getTitle());
            Glide.with(imageView.getContext())
                    .load(photo.getUrl())
                    .into(imageView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_photo_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(photoList.get(position));
    }

    @Override
    public int getItemCount() {
        return photoList != null ? photoList.size() : 0;
    }

    public void updateList(List<Photo> photoList) {
        this.photoList = photoList;
        notifyDataSetChanged();
    }
}
