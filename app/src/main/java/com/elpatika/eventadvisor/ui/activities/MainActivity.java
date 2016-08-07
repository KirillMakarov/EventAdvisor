package com.elpatika.eventadvisor.ui.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.widget.Toast;

import com.elpatika.eventadvisor.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    private BottomBar bottomBar;

    @BindView(R.id.activity_main_coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.activity_main_scrolling_content)
    View scrollingContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBar = BottomBar.attachShy((CoordinatorLayout) coordinatorLayout, scrollingContent, savedInstanceState);
        bottomBar.setItems(R.menu.main_menu);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.main_menu_feed:
                        Toast.makeText(getApplicationContext(), "Hello, CLICK MAIN", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_menu_schedule:
                        Toast.makeText(getApplicationContext(), "Hello, CLICK SCHEDULE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_menu_settings:
                        Toast.makeText(getApplicationContext(), "Hello, CLICK SETTINGS", Toast.LENGTH_SHORT).show();
                        break;

                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.main_menu_feed:
                        Toast.makeText(getApplicationContext(), "Hello, RE-CLICK MAIN", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_menu_schedule:
                        Toast.makeText(getApplicationContext(), "Hello, RE-CLICK SCHEDULE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.main_menu_settings:
                        Toast.makeText(getApplicationContext(), "Hello, RE-CLICK SETTINGS", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }
}
