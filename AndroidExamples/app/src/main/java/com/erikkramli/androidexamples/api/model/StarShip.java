package com.erikkramli.androidexamples.api.model;

import com.erikkramli.androidexamples.api.json.StarShipJson;

public class StarShip {

    private final String name;
    private final String model;
    private final String manufacturer;
    private final String crew;
    private final String passengers;

    public StarShip(StarShipJson starShipJson) {
        name = starShipJson.getName();
        model = starShipJson.getModel();
        manufacturer = starShipJson.getManufacturer();
        crew = starShipJson.getCrew();
        passengers = starShipJson.getPassengers();
    }

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
