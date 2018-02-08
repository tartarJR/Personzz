package com.tatar.personzz.di;

import com.squareup.picasso.Picasso;
import com.tatar.personzz.data.network.PersonzzService;
import com.tatar.personzz.di.modules.PersonzzServiceModule;
import com.tatar.personzz.di.modules.PicassoModule;

import dagger.Component;

/**
 * Created by mobile on 8.02.2018.
 */

@Component(modules = {PersonzzServiceModule.class, PicassoModule.class})
public interface AppComponent {
    PersonzzService getPersonzzService();

    Picasso getPicasso();
}
