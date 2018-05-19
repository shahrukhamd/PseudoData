package com.sasiddiqui.pseudodata.di.component;

import com.sasiddiqui.pseudodata.di.module.PhotoAPIModule;
import com.sasiddiqui.pseudodata.network.api.PhotoAPI;

import dagger.Component;

/**
 * Created by shahrukhamd on 19/05/18.
 */
@Component(modules = PhotoAPIModule.class)
public interface PhotoAPIComponent {

    PhotoAPI getPhotoAPI();
}
