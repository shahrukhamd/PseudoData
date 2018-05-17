package com.sasiddiqui.pseudodata;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by shahrukhamd on 17/05/18.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());
    }
}
