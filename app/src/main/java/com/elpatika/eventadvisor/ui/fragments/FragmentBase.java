package com.elpatika.eventadvisor.ui.fragments;

import android.support.v4.app.Fragment;

import butterknife.Unbinder;

public abstract class FragmentBase extends Fragment {

    protected Unbinder unbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}