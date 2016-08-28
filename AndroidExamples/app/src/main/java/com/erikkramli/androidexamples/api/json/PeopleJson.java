package com.erikkramli.androidexamples.api.json;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public class PeopleJson {

    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<CharacterJson> characters = Collections.emptyList();

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<CharacterJson> getCharacters() {
        return characters;
    }
}
