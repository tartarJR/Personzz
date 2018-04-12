package com.tatar.personzz.ui.personz;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tatar.personzz.App;
import com.tatar.personzz.R;
import com.tatar.personzz.data.network.PersonzzService;
import com.tatar.personzz.data.network.modal.PersonzResponse;
import com.tatar.personzz.data.network.modal.Result;
import com.tatar.personzz.di.component.DaggerPersonzActivityComponent;
import com.tatar.personzz.di.component.PersonzActivityComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class PersonzActivity extends AppCompatActivity {

    private RecyclerView personzRecyclerView;

    @Inject
    PersonzAdapter personzAdapter;

    @Inject
    PersonzzService personzzService;

    Call<PersonzResponse> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personz);

        PersonzActivityComponent personzActivityComponent = DaggerPersonzActivityComponent.builder().appComponent(App.get(this).getAppComponent()).build();
        personzActivityComponent.inject(this);

        initViews();
        personzzCall();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (call != null) {
            call.cancel();
        }
    }

    private void initViews() {
        personzRecyclerView = findViewById(R.id.personz_recycler_view);
        personzRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personzRecyclerView.setAdapter(personzAdapter);
    }

    private void personzzCall() {
        call = personzzService.getPersonz(20);
        call.enqueue(new Callback<PersonzResponse>() {
            @Override
            public void onResponse(Call<PersonzResponse> call, @NonNull Response<PersonzResponse> response) {
                if (response.isSuccessful()) {
                    List<Result> results = response.body().getResults();
                    personzAdapter.setPersonList(results);
                }
            }

            @Override
            public void onFailure(Call<PersonzResponse> call, Throwable t) {
                Timber.i(t.getMessage());
            }
        });
    }
}
