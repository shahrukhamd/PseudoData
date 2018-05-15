package com.sasiddiqui.pseudodata.presentation.ui;

/**
 * Created by shahrukhamd on 15/05/18.
 * <p>
 * This view will define the basic functionality of a view.
 */
public interface BaseViewCallback {

    /**
     * This method will be used to show some kind of progress to the user when the lengthy background
     * task is going on.
     */
    void onShowProgress();

    /**
     * This method will be used to hide the progress (if visible) shown to the user.
     */
    void onHideProgress();

    /**
     * This method will be used to show the error to the user with a message.
     *
     * @param message The message describing the error.
     */
    void onError(String message);
}
