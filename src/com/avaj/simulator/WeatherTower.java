package com.avaj.simulator;

import com.avaj.simulator.Tower;
import com.avaj.weather.Coordinates;
import com.avaj.weather.WeatherProvider;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates);
    }

    void changeWeather()
    {
        this.conditionsChanged();
    }
}
