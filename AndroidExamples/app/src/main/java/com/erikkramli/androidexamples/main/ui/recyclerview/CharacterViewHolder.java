package com.erikkramli.androidexamples.main.ui.recyclerview;

import android.support.v7.widget.RecyclerView;

import com.erikkramli.androidexamples.main.ui.CharacterItemBinding;

public final class CharacterViewHolder extends RecyclerView.ViewHolder {

    private final CharacterItemBinding binding;

    public CharacterViewHolder(CharacterItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void setName(String name) {
        binding.characterNameText.setText(name);
    }

}
