package com.erikkramli.androidexamples.api.json;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public final class CharacterJson {

    @SerializedName("name")
    public String name;

    @SerializedName("height")
    public String height;

    @SerializedName("mass")
    public String mass;

    @SerializedName("hair_color")
    public String hairColor;

    @SerializedName("skin_color")
    public String skinColor;

    @SerializedName("eye_color")
    public String eyeColor;

    @SerializedName("birth_year")
    public String birthYear;

    @SerializedName("gender")
    public String gender;

    @SerializedName("starships")
    public List<String> starShipUrls = Collections.emptyList();
}
