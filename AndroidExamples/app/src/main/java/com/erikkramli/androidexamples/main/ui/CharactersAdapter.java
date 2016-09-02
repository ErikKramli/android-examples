package com.erikkramli.androidexamples.main.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.render.CharacterRender;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final List<StarWarsCharacter> characters;
    private final CharacterRender render;

    @Inject
    public CharactersAdapter(CharacterRender render) {
        this.render = render;
        characters = new ArrayList<>();
    }

    public void setCharacters(List<StarWarsCharacter> starWarsCharacters) {
        characters.clear();
        characters.addAll(starWarsCharacters);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    @Override
    public CharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return render.renderCharacterView(parent);
    }

    @Override
    public void onBindViewHolder(CharacterViewHolder holder, int position) {
        StarWarsCharacter starWarsCharacter = characters.get(position);
        holder.setName(starWarsCharacter.getName());
    }


}
