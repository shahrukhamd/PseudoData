package com.sasiddiqui.pseudodata.domain.interactor.implementation;

import com.sasiddiqui.pseudodata.domain.executor.Executor;
import com.sasiddiqui.pseudodata.domain.executor.MainThread;
import com.sasiddiqui.pseudodata.domain.interactor.GetAllPosts;
import com.sasiddiqui.pseudodata.domain.interactor.base.AbstractInteractor;
import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.domain.repository.PostsRepository;

import java.util.List;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * Implementation of {@link GetAllPosts}.
 */
public class GetAllPostsImpl extends AbstractInteractor implements GetAllPosts {

    private GetAllPosts.Callback callback;
    private PostsRepository repository;

    public GetAllPostsImpl(Executor mExecutor, MainThread mMainThread, GetAllPosts.Callback callback,
                           PostsRepository repository) {
        super(mExecutor, mMainThread);

        this.callback = callback;
        this.repository = repository;
    }

    @Override
    public void run() {
        final List<Post> postList = repository.getPosts();

        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                callback.onPostsRetrieved(postList);
            }
        });
    }
}
