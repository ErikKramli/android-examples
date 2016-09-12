package com.erikkramli.androidexamples.main.ui.render;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.erikkramli.androidexamples.R;
import com.erikkramli.androidexamples.main.ui.CharacterItemBinding;
import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

import javax.inject.Inject;

public final class CharacterRenderImpl implements CharacterRender {

    private final LayoutInflater inflater;
    private final DataBindingComponent bindingComponent;

    @Inject
    public CharacterRenderImpl(LayoutInflater inflater, DataBindingComponent bindingComponent) {
        this.inflater = inflater;
        this.bindingComponent = bindingComponent;
    }

    @Override
    public CharacterViewHolder renderCharacterView(ViewGroup parent) {
        CharacterItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.character_item, parent, false, bindingComponent);
        return new CharacterViewHolder(binding);
    }
}
