package com.erikkramli.androidexamples.main.ui.bind;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

import javax.inject.Inject;

public class DroidBinder implements CharacterBinder {

    @Inject
    public DroidBinder() {
    }

    @Override
    public void bindCharacter(CharacterViewHolder holder, StarWarsCharacter character) {
        holder.setName(character.getName() + " DROID");
    }
}
