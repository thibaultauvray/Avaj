package com.avaj.weather;

public class Coordinates
{
    private int longitude;

    private int latitude;

    private int height;

    public Coordinates(int longitude, int latitude, int height)
    {
        this.longitude = longitude;
        this.latitude = latitude;
        if (height > 100){
            height = 100;
        }
        else if (height < 0){
            height = 0;
        }
        this.height = height;
    }

    public int getLongitude()
    {
        return longitude;
    }

    public int getHeight() {
        return height;
    }

    public int getLatitude() {
        return latitude;
    }
}
