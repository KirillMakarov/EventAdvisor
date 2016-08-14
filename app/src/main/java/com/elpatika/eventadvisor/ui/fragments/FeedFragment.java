package com.elpatika.eventadvisor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elpatika.eventadvisor.R;

import butterknife.BindView;

public class FeedFragment extends FragmentBase {

    public static final String TAG = "feedFragmentTag";

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @BindView(R.id.feedRecyclerView)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}