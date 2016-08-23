package com.elpatika.eventadvisor.ui.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.ui.fragments.FeedFragment;
import com.elpatika.eventadvisor.ui.fragments.ScheduleFragment;
import com.elpatika.eventadvisor.ui.fragments.SettingsFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import butterknife.BindView;
import timber.log.Timber;

public class MainActivity extends BaseActivity {

    private BottomBar bottomBar;

    @BindView(R.id.activity_main_coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.frame)
    View frame;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        bottomBar = BottomBar.attachShy(coordinatorLayout, frame, savedInstanceState);
        bottomBar.noTabletGoodness(); // because with action bar side bar not working
        bottomBar.setItems(R.menu.main_menu);
        bottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                Fragment existingFragment = null;
                Timber.i("tab selected");
                switch (menuItemId) {
                    case R.id.main_menu_feed:
                        existingFragment = findFragment(FeedFragment.TAG);
                        if (existingFragment == null) {
                            existingFragment = FeedFragment.newInstance();
                            setFragment(R.id.frame, existingFragment, FeedFragment.TAG, true);
                        } else {
                            setFragment(R.id.frame, existingFragment, FeedFragment.TAG, false);
                        }

                        break;
                    case R.id.main_menu_schedule:
                        existingFragment = findFragment(ScheduleFragment.TAG);
                        if (existingFragment == null) {
                            existingFragment = ScheduleFragment.newInstance();
                            setFragment(R.id.frame, existingFragment, ScheduleFragment.TAG, true);
                        } else {
                            setFragment(R.id.frame, existingFragment, ScheduleFragment.TAG, false);
                        }

                        break;
                    case R.id.main_menu_settings:
                        existingFragment = findFragment(SettingsFragment.TAG);
                        if (existingFragment == null) {
                            existingFragment = SettingsFragment.newInstance();
                            setFragment(R.id.frame, existingFragment, SettingsFragment.TAG, true);
                        } else {
                            setFragment(R.id.frame, existingFragment, SettingsFragment.TAG, false);
                        }
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

    private void initToolbar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.frame);
        if (fragment == null || fragment.getTag().equals(FeedFragment.TAG)) {
            finish();
        } else {
            bottomBar.selectTabAtPosition(0, true);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        bottomBar.onSaveInstanceState(outState);
    }

    @Nullable
    private Fragment findFragment(String Tag) {
        return getSupportFragmentManager().findFragmentByTag(Tag);
    }
}
