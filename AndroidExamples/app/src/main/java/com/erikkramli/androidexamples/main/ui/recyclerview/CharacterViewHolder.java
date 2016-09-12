package com.erikkramli.androidexamples.main.ui.recyclerview;

import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.CharacterItemBinding;
import com.erikkramli.androidexamples.util.ViewUtils;

public final class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterItemBinding binding;

    public CharacterViewHolder(CharacterItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setStarWarsCharacter(StarWarsCharacter character) {
        binding.setCharacter(character);
    }

    public void showGender() {
        ViewUtils.visible(binding.gender);
    }

    public void hideGender() {
        ViewUtils.gone(binding.gender);
    }

    public void setBackgroundColor(@ColorRes int colorRes) {
        binding.setBgColorRes(colorRes);
    }
}
