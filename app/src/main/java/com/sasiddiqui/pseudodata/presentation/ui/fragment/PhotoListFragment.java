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

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.di.component.DaggerPhotoAPIComponent;
import com.sasiddiqui.pseudodata.di.component.PhotoAPIComponent;
import com.sasiddiqui.pseudodata.di.module.PhotoAPIModule;
import com.sasiddiqui.pseudodata.network.model.Photo;
import com.sasiddiqui.pseudodata.presentation.ui.adapter.PhotosRVAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by shahrukhamd on 16/05/18.
 */
public class PhotoListFragment extends Fragment implements
        Callback<List<Photo>>,
        SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.photo_list_help_text)
    TextView helpTextView;
    @BindView(R.id.photo_list_recycler_view)
    RecyclerView photosRecyclerView;
    @BindView(R.id.photo_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private PhotosRVAdapter photosRVAdapter;
    private PhotoAPIComponent photoAPIComponent;
    private List<Photo> photoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_photo_list, container, false);
        ButterKnife.bind(this, view);

        photoList = new ArrayList<>();
        photosRVAdapter = new PhotosRVAdapter();
        photosRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        photosRecyclerView.setAdapter(photosRVAdapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        photoAPIComponent = DaggerPhotoAPIComponent.builder().photoAPIModule(new PhotoAPIModule()).build();
        getData();

        return view;
    }

    @Override
    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
        if (response.isSuccessful() && response.body() != null) {
            photoList = response.body();
        }
        refreshViews();
    }

    @Override
    public void onFailure(Call<List<Photo>> call, Throwable t) {
        refreshViews();
        Timber.e(t);
    }

    @Override
    public void onRefresh() {
        getData();
    }

    private void getData() {
        swipeRefreshLayout.setRefreshing(true);
        Call<List<Photo>> photoList = photoAPIComponent.getPhotoAPI().getPhotos();
        photoList.enqueue(this);
    }

    private void refreshViews() {
        swipeRefreshLayout.setRefreshing(false);
        photosRVAdapter.updateList(photoList);
        helpTextView.setVisibility(photoList.size() > 0 ? View.GONE : View.VISIBLE);
    }
}
