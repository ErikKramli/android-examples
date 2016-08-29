package com.erikkramli.androidexamples.api.json;

import com.google.gson.annotations.SerializedName;

import java.util.Collections;
import java.util.List;

public final class StarShipsJson {

    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<StarShipJson> starShips = Collections.emptyList();

    public List<StarShipJson> getStarShips() {
        return starShips;
    }
}
