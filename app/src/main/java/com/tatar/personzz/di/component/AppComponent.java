package com.tatar.personzz.di.component;

import com.tatar.personzz.di.module.PersonzzServiceModule;
import com.tatar.personzz.di.module.PicassoModule;
import com.tatar.personzz.ui.personz.PersonzActivity;

import dagger.Component;

/**
 * Created by mobile on 8.02.2018.
 */

@Component(modules = {PersonzzServiceModule.class, PicassoModule.class})
public interface AppComponent {
    void inject(PersonzActivity personzActivity);
}
