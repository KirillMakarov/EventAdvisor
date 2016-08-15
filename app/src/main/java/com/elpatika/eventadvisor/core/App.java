package com.elpatika.eventadvisor.core;

import android.app.Application;
import android.support.annotation.NonNull;

import com.elpatika.eventadvisor.BuildConfig;
import com.facebook.drawee.backends.pipeline.Fresco;

import timber.log.Timber;

public class App extends Application {

    private static App application;
    private AppComponent component;

    @NonNull
    public static App get() {
        return (App) application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        application = this;
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();


        Fresco.initialize(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static AppComponent component() {
        return application.component;
    }
}
