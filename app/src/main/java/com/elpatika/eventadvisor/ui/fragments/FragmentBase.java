package com.elpatika.eventadvisor.ui.fragments;

import android.support.v4.app.Fragment;

import com.elpatika.eventadvisor.core.App;

import butterknife.Unbinder;

public abstract class FragmentBase extends Fragment {

    protected Unbinder unbinder;

    FragmentBase() {
        initDependencies(); // persistent to config changes.
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    // App.component.plusSomething().inject();
    public void initDependencies() {
        //base implementation:
        App.component().inject(this);
    }
}