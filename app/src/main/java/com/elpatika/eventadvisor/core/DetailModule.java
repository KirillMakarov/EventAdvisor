package com.elpatika.eventadvisor.core;

import com.elpatika.eventadvisor.ui.presenters.DetailEventPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {
    @Provides
    public DetailEventPresenter providePresenter() {
        return new DetailEventPresenter();
    }
}
