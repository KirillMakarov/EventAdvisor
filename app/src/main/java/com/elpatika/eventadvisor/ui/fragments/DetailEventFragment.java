package com.elpatika.eventadvisor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.core.DetailModule;
import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.presenters.DetailEventPresenter;
import com.elpatika.eventadvisor.ui.views.DetailEventView;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailEventFragment extends FragmentBase implements DetailEventView {
    public static DetailEventFragment newInstance(Event event) {
        Bundle args = new Bundle();
        DetailEventFragment fragment = new DetailEventFragment();
        args.putParcelable(eventKey, event);
        fragment.setArguments(args);
        return fragment;
    }

    private static final String eventKey = "eventKey";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    DetailEventPresenter detailEventPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_event, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailEventPresenter.attachView(this);
        initEvent();
        detailEventPresenter.initTitle();
    }

    @Override
    public void onDestroyView() {
        detailEventPresenter.detachView(this);
        super.onDestroyView();
    }

    @Override
    public void onInitToolbar() {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public String getTitleString() {
        return ""; // default nothing
    }

    @Override
    public void initDependencies() {
        App
                .component()
                .plusDetailModule(new DetailModule())
                .inject(this);
    }

    private void initEvent() {
        Event event = getArguments().getParcelable(eventKey);
        if (event != null) {
            detailEventPresenter.setEvent(event);
        }
    }

    @Override
    public void setEventTitle(String title) {
        setTitle(title);
    }
}
