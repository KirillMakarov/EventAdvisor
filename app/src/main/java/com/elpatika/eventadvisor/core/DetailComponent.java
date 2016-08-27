package com.elpatika.eventadvisor.core;

import com.elpatika.eventadvisor.ui.fragments.DetailEventFragment;

import dagger.Subcomponent;

@PerFragment
@Subcomponent(modules = {DetailModule.class})
public interface DetailComponent {
    void inject(DetailEventFragment detailEventFragment);
}
