package com.tatar.personzz;

import android.app.Activity;
import android.app.Application;

import com.tatar.personzz.di.component.AppComponent;
import com.tatar.personzz.di.component.DaggerAppComponent;
import com.tatar.personzz.di.module.ContextModule;

import timber.log.Timber;

/**
 * Created by mobile on 12.02.2018.
 */

public class App extends Application {

    private AppComponent appComponent;

    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        appComponent = DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
