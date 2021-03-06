package com.tatar.personzz.data.network;

import com.tatar.personzz.data.network.modal.PersonzResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mobile on 7.02.2018.
 */

public interface PersonzzService {
    @GET(PersonzzServiceConstants.GET_ALL_PERSONZ)
    Call<PersonzResponse> getPersonz(@Query(PersonzzServiceConstants.GET_ALL_PERSONZ_QUERY_STRING) int size);
}

