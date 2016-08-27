package com.elpatika.eventadvisor.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.activities.DetailEventActivity;
import com.elpatika.eventadvisor.ui.views.DetailEventView;

public class ScreenManagerImpl implements ScreenManager {
    @Override
    public void showDetailActivityIntent(Activity sourceActivity, Event event) {
        Intent intent = new Intent(sourceActivity, DetailEventActivity.class);
        intent.putExtra(DetailEventActivity.eventKey, event);
        sourceActivity.startActivity(intent);
    }
}
