package com.avaj.weather;

import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private static String[] weather = {
            "RAIN", "FOG", "SUN", "SNOW"
    };

    private WeatherProvider()
    {

    }

    public static WeatherProvider getWeatherProvider()
    {
        return WeatherProvider.weatherProvider;
    }

        
    public String getCurrentWeather(Coordinates coordinates)
    {
        int seed = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        Random rand = new Random(seed);

        return weather[rand.nextInt(Integer.MAX_VALUE) % 4];
    }

	public String[] getWeather() {
		return weather;
	}
}
