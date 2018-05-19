package com.sasiddiqui.pseudodata.di.module;

import com.sasiddiqui.pseudodata.network.api.PhotoAPI;
import com.sasiddiqui.pseudodata.network.utils.APIConstants;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shahrukhamd on 19/05/18.
 *
 * A module responsible for providing the required dependencies for Photo API.
 */
@Module
public class PhotoAPIModule {

    @Provides
    public PhotoAPI getPhotoAPI(Retrofit retrofit) {
        return retrofit.create(PhotoAPI.class);
    }

    @Provides
    public Retrofit getRetrofit(GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory getGsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}
