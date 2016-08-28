package com.erikkramli.androidexamples.api;

import com.erikkramli.androidexamples.api.json.PeopleJson;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StarWarsApi {

    String BASE_URL = "http://swapi.co/api/";

    @GET("people/")
    Call<PeopleJson> getPeople(@Query("page") int page);
}
