package com.elpatika.eventadvisor.ui.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.elpatika.eventadvisor.R;

public abstract class SingleFragmentActivity extends BaseActivity {
    protected abstract Fragment createFragment();

    @LayoutRes
    protected int getLayoutResId() {
        return R.layout.activity_single_fragment;
    }

    @IdRes
    protected int getIdOfContainer() {
        return R.id.frame;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Fragment oldFragment = supportFragmentManager.findFragmentById(getIdOfContainer());

        if (oldFragment == null) {
            Fragment newFragment = createFragment();
            supportFragmentManager
                    .beginTransaction()
                    .add(getIdOfContainer(), newFragment)
                    .commit();
        }
    }
}
