package com.sasiddiqui.pseudodata.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.network.api.TodoAPI;
import com.sasiddiqui.pseudodata.network.model.Todo;
import com.sasiddiqui.pseudodata.network.utils.APIConstants;
import com.sasiddiqui.pseudodata.network.utils.RetrofitBuilder;
import com.sasiddiqui.pseudodata.presentation.ui.adapter.TodosRVAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by shahrukhamd on 16/05/18.
 *
 * A simple fragment showing the use of RxJava2 and Retrofit2 in combination with each other.
 */
public class TodoListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.todo_list_help_text)
    TextView helpTextView;
    @BindView(R.id.todo_list_recycler_view)
    RecyclerView todoRecyclerView;
    @BindView(R.id.todo_list_swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    private TodosRVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_todo_list, container, false);
        ButterKnife.bind(this, view);

        adapter = new TodosRVAdapter();
        todoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        todoRecyclerView.setAdapter(adapter);

        getData();

        return view;
    }

    private void getData() {
        swipeRefreshLayout.setRefreshing(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(RetrofitBuilder.getLogInterceptorClient())
                .build();

        // Instantiate the API interface and get the observable
        TodoAPI todoAPI = retrofit.create(TodoAPI.class);
        Observable<List<Todo>> todoObservable = todoAPI.getTodos();

        Observer<List<Todo>> observer = new Observer<List<Todo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<Todo> todoList) {
                adapter.updateList(todoList);

                swipeRefreshLayout.setRefreshing(false);
                helpTextView.setVisibility(todoList.size() > 0 ? View.GONE : View.VISIBLE);
            }

            @Override
            public void onError(Throwable e) {
                Timber.e(e);
            }

            @Override
            public void onComplete() {
                Timber.d("Observer Completed");
            }
        };

        todoObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void onRefresh() {
        getData();
    }
}
