package com.elpatika.eventadvisor.core;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

public class App extends Application {

    private static App application;

    @NonNull
    public static App get(@NonNull Context context) {
        return (App) application;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        application = this;
    }
}
