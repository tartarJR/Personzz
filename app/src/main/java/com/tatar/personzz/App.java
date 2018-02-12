package com.tatar.personzz;

import android.app.Application;

import com.tatar.personzz.di.component.AppComponent;
import com.tatar.personzz.di.component.DaggerAppComponent;
import com.tatar.personzz.di.module.ContextModule;

/**
 * Created by mobile on 12.02.2018.
 */

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildAppComponent();
    }

    public AppComponent buildAppComponent() {
        return DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }
}
