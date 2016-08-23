package com.elpatika.eventadvisor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
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
        setTitle(getTitleRes());
        Timber.i("onViewCreated %s", this.toString());
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

    private void setTitle(@StringRes int titleRes) {
        getActivity().setTitle(titleRes);
    }

    @StringRes
    public abstract int getTitleRes();

}