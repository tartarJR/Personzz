package com.tatar.personzz.di.module;

import com.jakewharton.picasso.OkHttp3Downloader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by mobile on 8.02.2018.
 */

@Module
public class OkHttpClientModule {

    @Provides
    @Singleton
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @Singleton
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

    @Provides
    @Singleton
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}
