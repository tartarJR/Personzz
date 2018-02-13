package com.tatar.personzz.di.module;

import com.tatar.personzz.data.network.PersonzzService;
import com.tatar.personzz.data.network.PersonzzServiceConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mobile on 8.02.2018.
 */

@Module
public class PersonzzServiceModule {

    @Singleton
    @Provides
    public PersonzzService personzzService(Retrofit retrofit) {
        return retrofit.create(PersonzzService.class);
    }

    @Singleton
    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(PersonzzServiceConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Singleton
    @Provides
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}
