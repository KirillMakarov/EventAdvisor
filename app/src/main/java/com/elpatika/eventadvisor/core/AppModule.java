package com.elpatika.eventadvisor.core;

import com.elpatika.eventadvisor.web.Api;
import com.elpatika.eventadvisor.web.ApiImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Singleton
    @Provides
    Api provideApi() {
        return new ApiImpl();
    }
}
