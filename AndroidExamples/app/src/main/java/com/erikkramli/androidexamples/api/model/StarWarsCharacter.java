package com.erikkramli.androidexamples.api.model;

import com.erikkramli.androidexamples.api.json.CharacterJson;
import com.erikkramli.androidexamples.api.util.PageNumberParser;

public final class StarWarsCharacter {

    private static final String UNKNOWN = "n/a";

    private final String name;
    private final String gender;
    private final String height;
    private final String skinColor;
    private final String birthYear;
    private final int[] starShipIds;

    public StarWarsCharacter(CharacterJson json) {
        name = json.name;
        gender = json.gender;
        height = json.height;
        skinColor = json.skinColor;
        birthYear = json.birthYear;
        starShipIds = new int[json.starShipUrls.size()];
        for (int i = 0, n = starShipIds.length; i < n; i++) {
            String starShipUrl = json.starShipUrls.get(i);
            starShipIds[i] = PageNumberParser.parse(starShipUrl);
        }
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

    public String getSkinColor() {
        return skinColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    private int[] getStarShipIds() {
        return starShipIds;
    }

    private boolean isDroid() {
        return UNKNOWN.equalsIgnoreCase(gender);
    }
}
