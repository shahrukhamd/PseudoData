package com.sasiddiqui.pseudodata.domain.repository;

import android.support.annotation.NonNull;

import com.sasiddiqui.pseudodata.domain.model.Comment;
import com.sasiddiqui.pseudodata.domain.model.Post;

import java.util.List;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * An interface defining the methods to interact with the repository for operations regarding {@link Post}
 */
public interface PostsRepository {

    /**
     * Get the list of {@link Post}.
     */
    @NonNull
    List<Post> getPosts();

    /**
     * Get all the comments of a post.
     *
     * @param postId The post ID.
     */
    List<Comment> getPostComments(int postId);
}
