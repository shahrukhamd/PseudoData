package com.sasiddiqui.pseudodata.network;

import android.support.annotation.NonNull;

import com.sasiddiqui.pseudodata.domain.model.Comment;
import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.domain.repository.PostsRepository;
import com.sasiddiqui.pseudodata.network.api.PostsAPI;
import com.sasiddiqui.pseudodata.network.utils.RetrofitBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by shahrukhamd on 15/05/18.
 */
public class PostsRepositoryImpl implements PostsRepository {

    @Override
    @NonNull
    public List<Post> getPosts() {
        List<Post> postList = new ArrayList<>();
        PostsAPI postsAPI = RetrofitBuilder.getRetrofit().create(PostsAPI.class);
        Call<List<com.sasiddiqui.pseudodata.network.model.Post>> call = postsAPI.getPosts();

        try {
            Response<List<com.sasiddiqui.pseudodata.network.model.Post>> response = call.execute();

            if (response.isSuccessful() && response.body() != null) {
                // Initializing posts list with appropriate data.
                for (com.sasiddiqui.pseudodata.network.model.Post postNetwork: response.body()){
                    Post post = new Post()
                            .setPostId(postNetwork.getId())
                            .setUserId(postNetwork.getUserId())
                            .setBody(postNetwork.getBody())
                            .setTitle(postNetwork.getTitle());

                    postList.add(post);
                }
            }

        } catch (IOException e) {
            Timber.e(e);
        }

        return postList;
    }

    @Override
    public List<Comment> getPostComments(int postId) {
        List<Comment> commentList = new ArrayList<>();
        // TODO Get the list from API.
        return commentList;
    }
}
