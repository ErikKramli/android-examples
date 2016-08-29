package com.erikkramli.androidexamples.api;

import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.model.StarShip;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;

import java.util.List;

public interface StarWarsRepository {

    List<StarWarsCharacter> getCharacters(int page) throws ApiException;

    List<StarShip> getStarShips(int page) throws ApiException;
}
