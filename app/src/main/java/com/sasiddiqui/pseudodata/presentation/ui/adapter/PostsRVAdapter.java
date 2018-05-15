package com.sasiddiqui.pseudodata.presentation.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.domain.model.Post;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shahrukhamd on 15/05/18.
 */
public class PostsRVAdapter extends RecyclerView.Adapter<PostsRVAdapter.ViewHolder> {

    private List<Post> postList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.post_list_item_title)
        TextView postTitle;
        @BindView(R.id.post_list_item_body)
        TextView postBody;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindData(Post post) {
            postTitle.setText(post.getTitle());
            postBody.setText(post.getBody());
        }
    }

    public void updateList(@NonNull List<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_post_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList != null ? postList.size() : 0;
    }
}
