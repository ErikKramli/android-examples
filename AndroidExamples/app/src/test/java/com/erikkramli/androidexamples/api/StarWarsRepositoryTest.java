package com.erikkramli.androidexamples.api;

import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.model.Character;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class StarWarsRepositoryTest {

    private final StarWarsRepository repository;

    public StarWarsRepositoryTest() {
        StarWarsApi api = new Retrofit.Builder()
                .baseUrl(StarWarsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build()
                .create(StarWarsApi.class);
        repository = new StarWarsRepositoryImpl(api);
    }

    @Test
    public void When_getPeople_invoked_Then_valid_response_received() throws ApiException {
        List<Character> characters = repository.getCharacters(1);
        assertThat(characters, notNullValue());
    }
}
