package com.elpatika.eventadvisor.core;

import com.elpatika.eventadvisor.ui.presenters.EventFeedPresenter;
import com.elpatika.eventadvisor.web.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class FeedModule {
    @Provides
    public EventFeedPresenter providePresenter(Api api) {
        return new EventFeedPresenter(api);
    }
}
