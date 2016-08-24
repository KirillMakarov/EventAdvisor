package com.elpatika.eventadvisor.ui.activities;

import android.support.v4.app.Fragment;

import com.elpatika.eventadvisor.ui.fragments.DetailEventFragment;

public class DetailEventActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return DetailEventFragment.newInstance();
    }
}
