package com.sasiddiqui.pseudodata.domain.interactor.base;

import com.sasiddiqui.pseudodata.domain.executor.Executor;
import com.sasiddiqui.pseudodata.domain.executor.MainThread;

/**
 * Created by shahrukhamd on 15/05/18.
 *
 * This abstract class implements some common methods for all the interactor like cancelling the
 * interactor or checking if it's still running.
 */

public abstract class AbstractInteractor implements Interactor {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    private volatile boolean mStillRunning;
    private volatile boolean mIsCancelled = false;

    public AbstractInteractor(Executor mExecutor, MainThread mMainThread){
        this.mExecutor = mExecutor;
        this.mMainThread = mMainThread;
    }

    /**
     * This method will be executed only through execute() and SHOULD NOT BE ACCESSED DIRECTLY unless
     * in a testing environment. This method contains the actual business logic code and which could
     * be a lengthy task so it should be run on background thread only to avoid any UI lags.
     */
    public abstract void run();

    public boolean isStillRunning() {
        return mStillRunning;
    }

    public void onFinish() {
        this.mStillRunning = false;
    }

    public boolean isCancelled() {
        return mIsCancelled;
    }

    public void cancel() {
        this.mIsCancelled = true;
        this.mStillRunning = false;
    }

    @Override
    public void execute() {
        this.mStillRunning = true;

        mExecutor.execute(this);
    }
}