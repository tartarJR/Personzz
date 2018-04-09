package com.tatar.personzz.di.module;

import com.squareup.picasso.Picasso;
import com.tatar.personzz.di.annotation.PersonzActivityScope;
import com.tatar.personzz.ui.personz.PersonzAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 9.04.2018.
 */

@Module
public class PersonzActivityModule {

    @Provides
    @PersonzActivityScope
    public PersonzAdapter personzAdapter(Picasso picasso) {
        return new PersonzAdapter(picasso);
    }

}
