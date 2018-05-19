package com.sasiddiqui.pseudodata.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.di.component.DaggerPhotoAPIComponent;
import com.sasiddiqui.pseudodata.di.component.PhotoAPIComponent;
import com.sasiddiqui.pseudodata.di.module.PhotoAPIModule;
import com.sasiddiqui.pseudodata.network.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by shahrukhamd on 16/05/18.
 */
public class PhotoListFragment extends Fragment implements
        Callback<List<Photo>> {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_photo_list, container, false);

        PhotoAPIComponent photoAPIComponent = DaggerPhotoAPIComponent.builder().photoAPIModule(new PhotoAPIModule()).build();

        Call<List<Photo>> photoList = photoAPIComponent.getPhotoAPI().getPhotos();

        photoList.enqueue(this);

        return view;
    }

    @Override
    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
        Timber.d("Response");
    }

    @Override
    public void onFailure(Call<List<Photo>> call, Throwable t) {
        Timber.e(t);
    }
}
