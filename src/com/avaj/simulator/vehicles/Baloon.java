package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;
import com.avaj.simulator.WeatherTower;

import java.util.logging.Logger;

public class Baloon extends Aircraft implements Flyable
{

    private WeatherTower weatherTower;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);

        switch(weather){
            case "SUN":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Praise the sun, let's move up");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                break;
            case "RAIN":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): It's raining men, amen");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                break;
            case "FOG":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Holy Fog !");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                break;
            case "SNOW":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Winter is coming !");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                break;
        }
    }
    
    public void registerTower(WeatherTower Weathertower){
        this.weatherTower = Weathertower;
        weatherTower.register(this);
    }
}
