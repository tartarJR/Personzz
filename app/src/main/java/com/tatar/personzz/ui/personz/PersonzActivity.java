package com.tatar.personzz.ui.personz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tatar.personzz.R;
import com.tatar.personzz.data.network.ApiService;
import com.tatar.personzz.data.network.modal.PersonzResponse;
import com.tatar.personzz.data.network.modal.Result;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonzActivity extends AppCompatActivity {

    private static final String TAG = PersonzActivity.class.getSimpleName();

    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personz);

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor httpLoggingInterceptor = new
                HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Log.i(TAG, message);
            }
        });

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Call<PersonzResponse> call = retrofit.create(ApiService.class).getPersonz(7);
        call.enqueue(new Callback<PersonzResponse>() {
            @Override
            public void onResponse(Call<PersonzResponse> call, @NonNull Response<PersonzResponse> response) {
                if (response.isSuccessful()) {
                    List<Result> results = response.body().getResults();
                    Log.d(TAG, "Number of results received: " + results.size());
                }
            }

            @Override
            public void onFailure(Call<PersonzResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}
