package com.avaj.simulator.vehicles;

import com.avaj.simulator.WeatherTower;
import com.avaj.weather.Coordinates;

public interface Flyable {

    void updateConditions();

    String getName();

    long getId();

    Coordinates getCoordinates();

    void registerTower(WeatherTower WeatherTower);
}
