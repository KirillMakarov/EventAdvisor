package com.elpatika.eventadvisor.core;

import com.elpatika.eventadvisor.ui.adapters.EventsAdapter;
import com.elpatika.eventadvisor.ui.fragments.FragmentBase;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    FeedComponent plusFeedModule(FeedModule module);

    void inject(FragmentBase fragmentBase);

    void inject(EventsAdapter eventsAdapter);
}
