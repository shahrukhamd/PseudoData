package com.sasiddiqui.pseudodata.domain.interactor;

import com.sasiddiqui.pseudodata.domain.interactor.base.Interactor;
import com.sasiddiqui.pseudodata.domain.model.Post;

import java.util.List;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * This interface will define the methods that will be used to get all the pseudo posts.
 */
public interface GetAllPosts extends Interactor {

    interface Callback {
        /**
         * A callback is to pass the retrieved list of {@link Post} to the listener.
         */
        void onPostsRetrieved(List<Post> postList);
    }
}