package com.erikkramli.androidexamples.main.ui.bind;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

import javax.inject.Inject;

public class MaleBinder implements CharacterBinder {

    @Inject
    public MaleBinder() {
    }

    @Override
    public void bindCharacter(CharacterViewHolder holder, StarWarsCharacter character) {
        holder.setStarWarsCharacter(character);
        holder.showGender();
        holder.setBackgroundColor(R.color.green);
    }
}
