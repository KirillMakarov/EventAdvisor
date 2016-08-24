package com.elpatika.eventadvisor.core;

import android.app.Activity;
import android.content.Intent;

import com.elpatika.eventadvisor.ui.activities.DetailEventActivity;

public class ScreenManagerImpl implements ScreenManager {
    @Override
    public void showDetailActivityIntent(Activity sourceActivity) {
        Intent intent = new Intent(sourceActivity, DetailEventActivity.class);
        sourceActivity.startActivity(intent);
    }
}
