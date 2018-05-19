package com.sasiddiqui.pseudodata.network.api;

import com.sasiddiqui.pseudodata.network.model.Photo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shahrukhamd on 19/05/18.
 *
 * An interface for API call via {@link retrofit2.Retrofit}.
 */
public interface PhotoAPI {
    @GET("photos")
    Call<List<Photo>> getPhotos();
}
