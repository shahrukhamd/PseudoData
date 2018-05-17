package com.sasiddiqui.pseudodata.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.sasiddiqui.pseudodata.R;
import com.sasiddiqui.pseudodata.presentation.ui.fragment.TodoListFragment;
import com.sasiddiqui.pseudodata.presentation.ui.fragment.PostListFragment;
import com.sasiddiqui.pseudodata.presentation.ui.fragment.UserListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_bottom_navigation_bar)
    BottomNavigationView bottomNavigationView;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment_container, new PostListFragment())
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int selectedItem = bottomNavigationView.getSelectedItemId();

                switch (item.getItemId()) {
                    case R.id.bottom_nav_posts:
                        if (selectedItem == R.id.bottom_nav_posts) return false;
                        fragmentManager.beginTransaction()
                                .replace(R.id.main_fragment_container, new PostListFragment())
                                .commit();
                        return true;

                    case R.id.bottom_nav_todos:
                        if (selectedItem == R.id.bottom_nav_todos) return false;
                        fragmentManager.beginTransaction()
                                .replace(R.id.main_fragment_container, new TodoListFragment())
                                .commit();
                        return true;

                    case R.id.bottom_nav_users:
                        if (selectedItem == R.id.bottom_nav_users) return false;
                        fragmentManager.beginTransaction()
                                .replace(R.id.main_fragment_container, new UserListFragment())
                                .commit();
                        return true;
                }

                return false;
            }
        });
    }

}