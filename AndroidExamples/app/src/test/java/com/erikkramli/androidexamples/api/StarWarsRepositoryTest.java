package com.erikkramli.androidexamples.api;

import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.exception.NoContentException;
import com.erikkramli.androidexamples.api.model.StarShip;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

public class StarWarsRepositoryTest {

    private final StarWarsRepository repository;

    @Rule
    public ExpectedException expectedExceptionRuler;

    public StarWarsRepositoryTest() {
        expectedExceptionRuler = ExpectedException.none();

        StarWarsApi api = new Retrofit.Builder()
                .baseUrl(StarWarsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient())
                .build()
                .create(StarWarsApi.class);
        repository = new StarWarsRepositoryImpl(api);
    }

    @Test
    public void When_getCharacters_invoked_Then_valid_response_received() throws ApiException {
        List<StarWarsCharacter> characters = repository.getCharacters(1);

        assertThat(characters, notNullValue());
        assertThat(characters.size(), greaterThanOrEqualTo(0));
    }

    @Test
    public void When_getCharacters_invoked_With_invalid_page_index_Then_ApiException_thrown() throws ApiException {
        int page = 0;
        expectedExceptionRuler.expect(IllegalArgumentException.class);
        expectedExceptionRuler.expectMessage("Illegal page index " + page);
        repository.getCharacters(page);
    }

    @Test
    public void When_getCharacters_invoked_With_too_high_page_index_Then_ApiException_thrown() throws ApiException {
        int page = 1101310;
        expectedExceptionRuler.expect(NoContentException.class);
        expectedExceptionRuler.expectMessage("No content at page " + page);
        repository.getCharacters(page);
    }

    @Test
    public void When_getStarShips_invoked_Then_valid_response_received() throws ApiException {
        List<StarShip> characters = repository.getStarShips(1);

        assertThat(characters, notNullValue());
        assertThat(characters.size(), greaterThanOrEqualTo(0));
    }

    @Test
    public void When_getStarShips_invoked_With_invalid_page_index_Then_ApiException_thrown() throws ApiException {
        int page = -1;
        expectedExceptionRuler.expect(IllegalArgumentException.class);
        expectedExceptionRuler.expectMessage("Illegal page index " + page);
        repository.getStarShips(page);
    }

    @Test
    public void When_getStarShips_invoked_With_too_high_page_index_Then_ApiException_thrown() throws ApiException {
        int page = 323321;
        expectedExceptionRuler.expect(NoContentException.class);
        expectedExceptionRuler.expectMessage("No content at page " + page);
        repository.getCharacters(page);
    }
}
