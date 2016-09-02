package com.erikkramli.androidexamples.main.ui.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.erikkramli.androidexamples.api.model.Gender;
import com.erikkramli.androidexamples.api.model.StarWarsCharacter;
import com.erikkramli.androidexamples.main.ui.bind.CharacterBinder;
import com.erikkramli.androidexamples.main.ui.render.CharacterRender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

public class CharactersAdapter extends RecyclerView.Adapter<CharacterViewHolder> {

    private final CharacterRender render;
    private final Map<String, CharacterBinder> binders;
    private final List<StarWarsCharacter> characters;

    @Inject
    public CharactersAdapter(CharacterRender render, Map<String, CharacterBinder> binders) {
        this.render = render;
        this.binders = binders;
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

        @Gender String key = starWarsCharacter.getGender();
        binders.get(key).bindCharacter(holder, starWarsCharacter);
    }
}
