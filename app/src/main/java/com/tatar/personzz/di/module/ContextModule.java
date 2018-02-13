package com.tatar.personzz.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 8.02.2018.
 */


@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context context() {
        return context.getApplicationContext();
    }

}
