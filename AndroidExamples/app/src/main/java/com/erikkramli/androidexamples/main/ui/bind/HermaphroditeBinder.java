package com.erikkramli.androidexamples.main.ui.bind;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

import javax.inject.Inject;

public class HermaphroditeBinder implements CharacterBinder {

    @Inject
    public HermaphroditeBinder() {
    }

    @Override
    public void bindCharacter(CharacterViewHolder holder, StarWarsCharacter character) {
        holder.setStarWarsCharacter(character);
        holder.hideGender();
        holder.setBackgroundColor(R.color.gray);
    }
}
