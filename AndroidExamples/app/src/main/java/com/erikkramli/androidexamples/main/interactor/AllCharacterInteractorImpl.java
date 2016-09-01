package com.erikkramli.androidexamples.main.interactor;

import android.util.Log;

import com.erikkramli.androidexamples.api.StarWarsRepository;
import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.exception.NoContentException;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class AllCharacterInteractorImpl implements AllCharacterInteractor {

    private static final String TAG = AllCharacterInteractorImpl.class.getSimpleName();

    private final StarWarsRepository repository;

    @Inject
    public AllCharacterInteractorImpl(StarWarsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<StarWarsCharacter> getAllStarWarsCharacter() {
        List<StarWarsCharacter> allCharacter = new ArrayList<>();

        int page = 0;
        ApiException noMoreContentException = null;
        while (noMoreContentException == null) {
            try {
                List<StarWarsCharacter> characters = repository.getCharacters(page++);
                allCharacter.addAll(characters);

            } catch (NoContentException e) {
                noMoreContentException = e;

            } catch (ApiException e) {
                Log.e(TAG, e.getMessage());
                break;
            }
        }

        return allCharacter;
    }
}
