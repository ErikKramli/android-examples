package com.erikkramli.androidexamples.api;

import android.util.Log;

import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.json.CharacterJson;
import com.erikkramli.androidexamples.api.json.PeopleJson;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class StarWarsRepositoryImpl implements StarWarsRepository {

    private static final String TAG = StarWarsRepositoryImpl.class.getSimpleName();

    private final StarWarsApi api;

    @Inject
    public StarWarsRepositoryImpl(StarWarsApi api) {
        this.api = api;
    }

    @Override
    public List<StarWarsCharacter> getCharacters(int page) throws ApiException {
        PeopleJson peopleJson = execute(api.getPeople(page));

        if (peopleJson == null)  {
            throw new ApiException("No content at page " + page);
        }

        List<StarWarsCharacter> characters = new ArrayList<>();
        for (CharacterJson characterJson : peopleJson.getCharacters()) {
            characters.add(new StarWarsCharacter(characterJson));
        }

        return characters;
    }

    private <RESPONSE> RESPONSE execute(Call<RESPONSE> retrofitCall) throws ApiException {
        try {
            return retrofitCall.execute().body();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            throw new ApiException("Network error", e);
        }
    }
}
