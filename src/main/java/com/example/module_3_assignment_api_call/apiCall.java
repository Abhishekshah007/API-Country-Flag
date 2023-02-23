package com.example.module_3_assignment_api_call;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
// here making get request with additional parameter
public interface apiCall {

    @GET("all?fields=name,flag")
    Call<List<countryModel>> getCountry();

    public interface Callback<T> {
        void onLoaded(T result);

        default void onError() {
        }
    }
}
