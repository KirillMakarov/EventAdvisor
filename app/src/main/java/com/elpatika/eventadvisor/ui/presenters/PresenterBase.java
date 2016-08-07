package com.elpatika.eventadvisor.ui.presenters;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Base presenter implementation.
 *
 * @param <V> view.
 */
public class PresenterBase<V> {

    @Nullable
    private volatile V view;

    @CallSuper
    public void attachView(@NonNull V view) {
        final V previousView = this.view;

        if (previousView != null) {
            throw new IllegalStateException("Previous view is not unbounded! previousView = " + previousView);
        }

        this.view = view;
    }

    @Nullable
    protected V getView() {
        return view;
    }

    @CallSuper
    public void detachView(@NonNull V view) {
        final V previousView = this.view;

        if (previousView == view) {
            this.view = null;
        } else {
            throw new IllegalStateException("Unexpected view! previousView = " + previousView + ", view to unbind = " + view);
        }
    }
}
