package com.sasiddiqui.pseudodata.network.api;

import com.sasiddiqui.pseudodata.network.model.Todo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by shahrukhamd on 17/05/18.
 *
 * An interface for API call via {@link retrofit2.Retrofit}.
 */
public interface TodoAPI {
    @GET("todos")
    Observable<List<Todo>> getTodos();
}
