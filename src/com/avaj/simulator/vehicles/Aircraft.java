package com.avaj.simulator.vehicles;

import com.avaj.simulator.WeatherTower;
import com.avaj.weather.Coordinates;

public class Aircraft
{
    protected long id;

    protected String name;


    protected Coordinates coordinates;

    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getName(){
        return this.name;
    }

    public long getId(){
        return this.id;
    }

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    private long nextId()
    {
        idCounter += 1;

        return idCounter;
    }
}
