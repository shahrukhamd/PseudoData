package com.sasiddiqui.pseudodata.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.domain.executor.implementation.ExecutorImpl;
import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.network.PostsRepositoryImpl;
import com.sasiddiqui.pseudodata.presentation.presenter.PostsPresenter;
import com.sasiddiqui.pseudodata.presentation.presenter.implementation.PostsPresenterImpl;
import com.sasiddiqui.pseudodata.presentation.ui.adapter.PostsRVAdapter;
import com.sasiddiqui.pseudodata.threading.MainThreadImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by shahrukhamd on 15/05/18.
 */
public class PostListFragment extends Fragment implements
        PostsPresenter.ViewCallback,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.post_list_help_text)
    TextView helpText;
    @BindView(R.id.post_list_recycler_view)
    RecyclerView postsRecyclerView;
    @BindView(R.id.post_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PostsPresenter postsPresenter;
    private PostsRVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_post_list, container, false);
        ButterKnife.bind(this, view);

        adapter = new PostsRVAdapter();

        swipeRefreshLayout.setOnRefreshListener(this);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        postsRecyclerView.setAdapter(adapter);

        postsPresenter = new PostsPresenterImpl(
                ExecutorImpl.getInstance(),
                MainThreadImpl.getInstance(),
                new PostsRepositoryImpl(),
                this
        );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        postsPresenter.resume();
    }

    @Override
    public void onPostsRetrieved(List<Post> postList) {
        adapter.updateList(postList);
        helpText.setVisibility(postList.size() > 0 ? View.GONE : View.VISIBLE);
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
        Toast.makeText(getContext(), R.string.message_some_error_occurred, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        postsPresenter.getPosts();
    }
}
