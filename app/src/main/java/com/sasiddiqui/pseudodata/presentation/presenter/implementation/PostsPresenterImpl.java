package com.sasiddiqui.pseudodata.presentation.presenter.implementation;

import com.sasiddiqui.pseudodata.domain.executor.Executor;
import com.sasiddiqui.pseudodata.domain.executor.MainThread;
import com.sasiddiqui.pseudodata.domain.interactor.GetAllPosts;
import com.sasiddiqui.pseudodata.domain.interactor.implementation.GetAllPostsImpl;
import com.sasiddiqui.pseudodata.domain.model.Post;
import com.sasiddiqui.pseudodata.domain.repository.PostsRepository;
import com.sasiddiqui.pseudodata.presentation.presenter.base.AbstractPresenter;
import com.sasiddiqui.pseudodata.presentation.presenter.PostsPresenter;

import java.util.List;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * Implementation of {@link PostsPresenter}.
 */
public class PostsPresenterImpl extends AbstractPresenter implements
        PostsPresenter,
        GetAllPosts.Callback {

    private PostsPresenter.ViewCallback viewCallback;
    private PostsRepository postsRepository;

    public PostsPresenterImpl(Executor mExecutor, MainThread mMainThread, PostsRepository postsRepository,
                              PostsPresenter.ViewCallback viewCallback) {
        super(mExecutor, mMainThread);

        this.postsRepository = postsRepository;
        this.viewCallback = viewCallback;
    }

    @Override
    public void resume() {
        viewCallback.onShowProgress();
        getPosts();
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onPostsRetrieved(List<Post> postList) {
        viewCallback.onHideProgress();
        viewCallback.onPostsRetrieved(postList);
    }

    private void getPosts() {
        GetAllPosts postInteractor = new GetAllPostsImpl(mExecutor, mMainThread, this, postsRepository);
        postInteractor.execute();
    }
}
