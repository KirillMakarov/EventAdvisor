package com.elpatika.eventadvisor.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.core.FeedModule;
import com.elpatika.eventadvisor.ui.adapters.EventsAdapter;
import com.elpatika.eventadvisor.presenters.EventFeedPresenter;
import com.elpatika.eventadvisor.presenters.views.EventFeedView;

import javax.inject.Inject;

import butterknife.BindView;

public class FeedFragment extends FragmentBase implements EventFeedView {

    public static final String TAG = "feedFragmentTag";

    public static FeedFragment newInstance() {
        return new FeedFragment();
    }

    @Inject
    EventFeedPresenter eventFeedPresenter;

    @BindView(R.id.feedRecyclerView)
    RecyclerView recyclerView;

    private EventsAdapter eventsAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        eventsAdapter = new EventsAdapter(eventFeedPresenter, getActivity());
        recyclerView.setAdapter(eventsAdapter);

        eventFeedPresenter.attachView(this);
        eventFeedPresenter.fetchData();
    }

    @Override
    public void onDestroyView() {
        eventFeedPresenter.detachView(this);
        eventsAdapter = null;
        super.onDestroyView();
    }

    @Override
    public void initDependencies() {
        App.component()
                .plusFeedModule(new FeedModule())
                .inject(this);
    }

    @Override
    public String getTitleString() {
        return App.get().getString(R.string.feed_title);
    }

    @Override
    public void showEvents() {
        eventsAdapter.notifyDataSetChanged();
    }

    @Override
    public void showConnectionError() {
        Toast.makeText(getContext(), "Sorry, connection error", Toast.LENGTH_SHORT).show(); //// TODO: 14.08.16  placeholder if empty, otherwise snack
    }

    @Override
    public void showLoad() {
        Toast.makeText(getContext(), "Loading...", Toast.LENGTH_SHORT).show(); // TODO: 14.08.16 add spinner, check empty
    }

}