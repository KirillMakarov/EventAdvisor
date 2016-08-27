package com.elpatika.eventadvisor.ui.presenters;

import android.support.annotation.NonNull;

import com.elpatika.eventadvisor.R;
import com.elpatika.eventadvisor.core.App;
import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.views.DetailEventView;

public class DetailEventPresenter extends PresenterBase<DetailEventView> {
    private Event event;

    public void setEvent(@NonNull Event event) {
        this.event = event;
    }


    @Override
    public void attachView(@NonNull DetailEventView view) {
        super.attachView(view);
    }

    public void initTitle() {
        String title = event.getTitle();
        if (title == null || title.isEmpty()) {
            title = App.get().getString(R.string.default_event_title);
        }

        if (getView() != null) {
            getView().setEventTitle(title);
        }
    }
}
