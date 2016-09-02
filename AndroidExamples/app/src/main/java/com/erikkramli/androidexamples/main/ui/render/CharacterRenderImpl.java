package com.erikkramli.androidexamples.main.ui.render;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.main.ui.CharacterItemBinding;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

import javax.inject.Inject;

public final class CharacterRenderImpl implements CharacterRender {

    private final LayoutInflater inflater;

    @Inject
    public CharacterRenderImpl(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public CharacterViewHolder renderCharacterView(ViewGroup parent) {
        CharacterItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.character_item, parent, false);
        return new CharacterViewHolder(binding);
    }
}
