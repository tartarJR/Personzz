package com.tatar.personzz.di.modules;

import com.google.gson.Gson;
import com.tatar.personzz.data.network.PersonzzService;

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
    @Provides
    public PersonzzService personzzService(Retrofit retrofit) {
        return retrofit.create(PersonzzService.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}
