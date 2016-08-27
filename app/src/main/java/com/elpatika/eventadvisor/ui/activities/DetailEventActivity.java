package com.elpatika.eventadvisor.ui.activities;

import android.support.v4.app.Fragment;

import com.elpatika.eventadvisor.model.Event;
import com.elpatika.eventadvisor.ui.fragments.DetailEventFragment;

public class DetailEventActivity extends SingleFragmentActivity {

    public static final String eventKey = "eventKey";

    @Override
    protected Fragment createFragment() {
        Event event = getIntent().getExtras().getParcelable(eventKey);
        return DetailEventFragment.newInstance(event);
    }
}
