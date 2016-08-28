package com.erikkramli.androidexamples.api.model;

import com.erikkramli.androidexamples.api.json.CharacterJson;

public final class Character {

    private String name;
    private String gender;
    private String height;

    public Character(CharacterJson json) {
        this.name = json.getName();
        this.gender = json.getGender();
        this.height = json.getHeight();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }
}
