package com.sasiddiqui.pseudodata.domain.executor;

/**
 * Created by shahrukhamd on 15/05/18.
 *
 * This interface will define a class that will be used by interactors to post anything on the main
 * thread in order to do some UI updates.
 */

public interface MainThread {

    /**
     * This method will make the runnable operations run in main thread.
     *
     * @param runnable The runnable which has the operation code.
     */
    void post(final Runnable runnable);
}
