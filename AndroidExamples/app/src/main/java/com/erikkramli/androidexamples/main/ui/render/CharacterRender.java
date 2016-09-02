package com.erikkramli.androidexamples.main.ui.render;

import android.view.ViewGroup;

import com.erikkramli.androidexamples.main.ui.recyclerview.CharacterViewHolder;

public interface CharacterRender {

    CharacterViewHolder renderCharacterView(ViewGroup parent);
}
