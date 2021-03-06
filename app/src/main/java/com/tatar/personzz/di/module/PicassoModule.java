package com.tatar.personzz.di.module;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.tatar.personzz.di.annotation.PersonzAppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by mobile on 8.02.2018.
 */

@Module(includes = {ContextModule.class, OkHttpClientModule.class})
public class PicassoModule {

    @Provides
    @PersonzAppScope
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context).
                downloader(okHttp3Downloader).
                build();
    }

    @Provides
    @PersonzAppScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
