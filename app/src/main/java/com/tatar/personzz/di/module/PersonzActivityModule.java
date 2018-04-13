package com.tatar.personzz.di.module;

import com.tatar.personzz.di.annotation.PersonzActivityScope;
import com.tatar.personzz.ui.personz.PersonzActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 9.04.2018.
 */

@Module
public class PersonzActivityModule {

    private final PersonzActivity personzActivity;

    public PersonzActivityModule(PersonzActivity personzActivity) {
        this.personzActivity = personzActivity;
    }

    @Provides
    @PersonzActivityScope
    public PersonzActivity personzActivity() {
        return personzActivity;
    }

}
