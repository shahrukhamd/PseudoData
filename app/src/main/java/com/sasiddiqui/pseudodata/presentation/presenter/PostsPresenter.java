package com.sasiddiqui.pseudodata.presentation.presenter;

import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.presentation.presenter.base.BasePresenter;
import com.sasiddiqui.pseudodata.presentation.ui.BaseViewCallback;

import java.util.List;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * An interface defining the main presenter methods.
 */
public interface PostsPresenter extends BasePresenter {

    interface ViewCallback extends BaseViewCallback {
        /**
         * On the retrieval of all the posts;
         */
        void onPostsRetrieved(List<Post> postList);
    }
}
