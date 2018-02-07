package com.tatar.personzz.ui.personz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tatar.personzz.R;
import com.tatar.personzz.data.network.ApiClient;
import com.tatar.personzz.data.network.ApiService;
import com.tatar.personzz.data.network.modal.PersonzResponse;
import com.tatar.personzz.data.network.modal.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonzActivity extends AppCompatActivity {

    private static final String TAG = PersonzActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personz);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        Call<PersonzResponse> call = apiService.getPersonz(10);
        call.enqueue(new Callback<PersonzResponse>() {
            @Override
            public void onResponse(Call<PersonzResponse> call, Response<PersonzResponse> response) {
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
