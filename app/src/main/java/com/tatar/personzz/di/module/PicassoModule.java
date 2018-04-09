package com.tatar.personzz.di.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mobile on 8.02.2018.
 */

@Module(includes = {ContextModule.class, OkHttpClientModule.class})
public class PicassoModule {

    @Provides
    @Singleton
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context).
                downloader(okHttp3Downloader).
                build();
    }
}
