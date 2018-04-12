package com.tatar.personzz.di.component;

import com.tatar.personzz.di.annotation.PersonzActivityScope;
import com.tatar.personzz.di.module.PersonzActivityModule;
import com.tatar.personzz.ui.personz.PersonzActivity;

import dagger.Component;

/**
 * Created by mobile on 9.04.2018.
 */

@Component(modules = PersonzActivityModule.class, dependencies = AppComponent.class)
@PersonzActivityScope
public interface PersonzActivityComponent {
    void inject(PersonzActivity personzActivity);
}
