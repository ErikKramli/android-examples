package com.erikkramli.androidexamples.api.json;

import com.google.gson.annotations.SerializedName;

public final class StarShipJson {

    @SerializedName("name")
    private String name;

    @SerializedName("model")
    private String model;

    @SerializedName("manufacturer")
    private String manufacturer;

    @SerializedName("crew")
    private String crew;

    @SerializedName("passengers")
    private String passengers;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }
}
