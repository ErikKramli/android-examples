package com.erikkramli.androidexamples.main.presenter;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;

import java.util.List;

public interface MainPresenter {

    interface Callback {
        void onSuccess(List<StarWarsCharacter> characters);
        void onFailure();
    }

    void loadStarWarsCharacters(Callback callback);
}
