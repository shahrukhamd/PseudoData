package com.sasiddiqui.pseudodata.presentation.presenter.base;

import com.sasiddiqui.pseudodata.domain.executor.Executor;
import com.sasiddiqui.pseudodata.domain.executor.MainThread;

/**
 * Created by shahrukhamd on 15/05/18.
 */

public abstract class AbstractPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor mExecutor, MainThread mMainThread) {
        this.mExecutor = mExecutor;
        this.mMainThread = mMainThread;
    }
}
