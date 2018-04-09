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

    PersonzActivityComponent personzActivityComponent;

    @Inject
    PersonzzService personzzService;

    Call<PersonzResponse> call;

    private RecyclerView personzRecyclerView;
    private PersonzAdapter personzAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personz);

        App.get(this).getAppComponent().inject(this);
        personzActivityComponent = DaggerPersonzActivityComponent.builder().appComponent(App.get(this).getAppComponent()).build();

        initViews();
        personzzCall();
    }

    private void initViews() {
        personzRecyclerView = findViewById(R.id.personz_recycler_view);
        personzRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        personzAdapter = personzActivityComponent.personzAdapter();
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
