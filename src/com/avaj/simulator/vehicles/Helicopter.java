package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;
import com.avaj.simulator.WeatherTower;

import java.util.logging.Logger;

public class Helicopter extends Aircraft implements Flyable
{

    private WeatherTower weatherTower;
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }
    
    public void updateConditions(){
        String weather = this.weatherTower.getWeather(this.coordinates);

        switch(weather){
            case "SUN":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): This is hot, let's go");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
                break;
            case "RAIN":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): I bless the rains down in Africa");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "FOG":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Let's Jump Into The Fog");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "SNOW":
                LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Let it go, let it go ! Can't hold it back anymore");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
                break;

        }
    }
    
    public void registerTower(WeatherTower Weathertower){
        this.weatherTower = Weathertower;
        weatherTower.register(this);

    }
}
