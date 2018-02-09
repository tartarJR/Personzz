package com.tatar.personzz.di;

import com.tatar.personzz.di.modules.PersonzzServiceModule;
import com.tatar.personzz.di.modules.PicassoModule;
import com.tatar.personzz.ui.personz.PersonzActivity;

import dagger.Component;

/**
 * Created by mobile on 8.02.2018.
 */

@Component(modules = {PersonzzServiceModule.class, PicassoModule.class})
public interface AppComponent {
    void inject(PersonzActivity personzActivity);
}
