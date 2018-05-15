package com.sasiddiqui.pseudodata.presentation.presenter.base;

/**
 * Created by shahrukhamd on 15/05/18.
 */

public interface BasePresenter {

    /**
     * Lifecycle method of the view which should be called from onResume() of Activity or Fragment.
     */
    void resume();

    /**
     * Lifecycle method of the view which should be called from onPause() of Activity or Fragment.
     */
    void pause();

    /**
     * Lifecycle method of the view which should be called from onStop() of Activity or Fragment.
     */
    void stop();

    /**
     * Lifecycle method of the view which should be called from onDestroy() of Activity or Fragment.
     */
    void destroy();

    /**
     * Method that should be called in case of encountering an error.
     */
    void onError();
}
