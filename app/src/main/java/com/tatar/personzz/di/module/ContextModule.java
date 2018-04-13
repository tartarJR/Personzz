package com.tatar.personzz.di.module;

import android.content.Context;

import com.tatar.personzz.di.annotation.PersonzAppScope;

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

    @Provides
    @PersonzAppScope
    public Context context() {
        return context.getApplicationContext();
    }

}
