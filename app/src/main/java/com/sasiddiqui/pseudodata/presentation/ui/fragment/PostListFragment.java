package com.sasiddiqui.pseudodata.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.presentation.presenter.PostsPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shahrukhamd on 15/05/18.
 */
public class PostListFragment extends Fragment implements PostsPresenter.ViewCallback {

    @BindView(R.id.post_list_help_text)
    TextView helpText;
    @BindView(R.id.post_list_recycler_view)
    RecyclerView postsRecyclerView;
    @BindView(R.id.post_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_post_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onPostsRetrieved(List<Post> postList) {

    }

    @Override
    public void onShowProgress() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void onHideProgress() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError() {

    }
}
