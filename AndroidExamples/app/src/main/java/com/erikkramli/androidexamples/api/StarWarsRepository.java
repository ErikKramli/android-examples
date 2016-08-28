package com.erikkramli.androidexamples.api;

import com.erikkramli.androidexamples.api.exception.ApiException;
import com.erikkramli.androidexamples.api.model.Character;

import java.util.List;

public interface StarWarsRepository {

    List<Character> getCharacters(int page) throws ApiException;
}
