package com.tatar.personzz.di.component;

import com.squareup.picasso.Picasso;
import com.tatar.personzz.data.network.PersonzzService;
import com.tatar.personzz.di.annotation.PersonzAppScope;
import com.tatar.personzz.di.module.PersonzzServiceModule;
import com.tatar.personzz.di.module.PicassoModule;

import dagger.Component;

/**
 * Created by mobile on 8.02.2018.
 */

@Component(modules = {PersonzzServiceModule.class, PicassoModule.class})
@PersonzAppScope
public interface AppComponent {
    PersonzzService personzzService();

    Picasso picasso();
}
