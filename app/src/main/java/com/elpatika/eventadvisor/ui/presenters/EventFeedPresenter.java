package com.elpatika.eventadvisor.ui.presenters;

import android.support.annotation.NonNull;

import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.views.EventFeedView;
import com.elpatika.eventadvisor.web.Api;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EventFeedPresenter extends PresenterBase<EventFeedView> {
    private Subscription apiSubscription;
    private Api api;
    private List<Event> eventList = new ArrayList<>();

    public EventFeedPresenter(Api api) {
        this.api = api;
    }


    public void fetchData() {
        if (getView() != null) {
            if (!eventList.isEmpty()) {
                getView().showEvents();
            } else {
                getView().showLoad();
            }
        }

        apiSubscription = api.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(eventsResponse -> eventsResponse.getResults())
                .subscribe(next -> {
                    if (getView() != null) {
                        eventList.clear(); //it will break if we add pagination.
                        eventList.addAll(next);
                        getView().showEvents();
                    }
                }, throwable -> {
                    if (getView() != null) {
                        getView().showConnectionError();
                    }
                });

        //// TODO: 14.08.16 ADD persistent layer:
//                .observeOn(Schedulers.io())
//                .subscribe(this::saveData, throwable -> {/*do nothing, because we handle in doOnError*/});

    }

    @Override
    public void detachView(@NonNull EventFeedView view) {
        super.detachView(view);
        if (apiSubscription != null && !apiSubscription.isUnsubscribed()) {
            apiSubscription.unsubscribe();
        }
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public int size() {
        return eventList.size();
    }

}
