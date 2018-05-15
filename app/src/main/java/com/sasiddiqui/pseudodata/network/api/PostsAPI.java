package com.sasiddiqui.pseudodata.network.api;

import com.sasiddiqui.pseudodata.network.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shahrukhamd on 15/05/18.
 *
 * An interface for API call via {@link retrofit2.Retrofit}.
 */
public interface PostsAPI {
    @GET("posts")
    Call<List<Post>> getPosts();
}
