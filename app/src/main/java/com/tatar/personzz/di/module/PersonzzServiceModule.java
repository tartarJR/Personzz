package com.tatar.personzz.di.module;

import com.tatar.personzz.data.network.PersonzzService;
import com.tatar.personzz.data.network.PersonzzServiceConstants;
import com.tatar.personzz.di.annotation.PersonzAppScope;

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
    @PersonzAppScope
    public PersonzzService personzzService(Retrofit retrofit) {
        return retrofit.create(PersonzzService.class);
    }

    @Provides
    @PersonzAppScope
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(PersonzzServiceConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @Provides
    @PersonzAppScope
    public GsonConverterFactory gsonConverterFactory() {
        return GsonConverterFactory.create();
    }
}
