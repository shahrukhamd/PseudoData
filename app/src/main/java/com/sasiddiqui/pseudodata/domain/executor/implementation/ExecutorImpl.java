package com.sasiddiqui.pseudodata.domain.executor.implementation;

import com.sasiddiqui.pseudodata.domain.executor.Executor;
import com.sasiddiqui.pseudodata.domain.interactor.base.AbstractInteractor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by shahrukhamd on 15/05/18.
 *
 * This singleton class will make sure that every thread will be executed in background on equal priority.
 */

public class ExecutorImpl implements Executor {

    // This is a singleton
    private static volatile ExecutorImpl executorImpl;

    private static final int                     CORE_POOL_SIZE  = 3;
    private static final int                     MAX_POOL_SIZE   = 5;
    private static final int                     KEEP_ALIVE_TIME = 120;
    private static final TimeUnit TIME_UNIT       = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> WORK_QUEUE      = new LinkedBlockingQueue<Runnable>();

    private ThreadPoolExecutor mThreadPoolExecutor;

    private ExecutorImpl() {
        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TIME_UNIT,
                WORK_QUEUE
        );
    }

    /**
     * Method to get an instance of this class. It will return the instance after creating it if
     * it's not available already.
     */
    public static ExecutorImpl getInstance() {
        if (executorImpl == null) {
            executorImpl = new ExecutorImpl();
        }

        return executorImpl;
    }

    @Override
    public void execute(final AbstractInteractor interactor) {
        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                // The main login resides only in this method.
                interactor.run();

                // Do the cleanup task on finishing.
                interactor.onFinish();
            }
        });
    }
}
