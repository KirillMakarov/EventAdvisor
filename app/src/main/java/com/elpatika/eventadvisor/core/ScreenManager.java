package com.elpatika.eventadvisor.core;

import android.app.Activity;

import com.elpatika.eventadvisor.model.Event;

public interface ScreenManager {
    void showDetailActivityIntent(Activity sourceActivity, Event event);
}
