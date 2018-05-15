package com.sasiddiqui.pseudodata.domain.executor;

import com.sasiddiqui.pseudodata.domain.interactor.base.AbstractInteractor;

/**
 * Created by shahrukhamd on 15/05/18.
 *
 * This interface will be responsible for executing different threads in background.
 */

public interface Executor {

    /**
     * This method will call the run() method of the interactors and will execute them in a separate
     * background thread.
     */
    void execute(final AbstractInteractor interactor);
}
