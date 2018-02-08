package com.tatar.personzz.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 8.02.2018.
 */

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context context() {
        return context.getApplicationContext();
    }

}
