package com.erikkramli.androidexamples.main.ui.bind;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

public interface CharacterBinder {

    void bindCharacter(CharacterViewHolder holder, StarWarsCharacter character);
}
