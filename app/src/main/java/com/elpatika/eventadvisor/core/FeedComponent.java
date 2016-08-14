package com.elpatika.eventadvisor.core;


import com.elpatika.eventadvisor.ui.fragments.FeedFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {FeedModule.class})
public interface FeedComponent {
    void inject(FeedFragment feedFragment);
}
