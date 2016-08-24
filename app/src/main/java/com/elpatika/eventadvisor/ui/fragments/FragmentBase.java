package com.elpatika.eventadvisor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.web.Api;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public abstract class FragmentBase extends Fragment {

    protected Unbinder unbinder;

    @Inject
    Api api;

    FragmentBase() {
        initDependencies(); // persistent to config changes.
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        onInitToolbar();
        setTitle(getTitleString());
        Timber.i("onViewCreated %s", this.toString());
    }

    public void onInitToolbar() {
        //Stub for override
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Timber.i("onCreate fragment %s", this.toString());
    }

    private void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public abstract String getTitleString();

}