package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;
import com.avaj.simulator.WeatherTower;

import java.util.logging.Logger;

public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);

		switch(weather){
			case "SUN":
				LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Set the controls for the heart of the sun");
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				break;
			case "RAIN":
				LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): But it's raining, raining in my heart");
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
				break;
			case "FOG":
				LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): This dark fog will appear");
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
				break;
			case "SNOW":
				LOGGER.info(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + "): Snowing and blowing up bushels of fun");
				this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
				break;
		}
	}

	public void registerTower(WeatherTower Weathertower){
		this.weatherTower = Weathertower;
		weatherTower.register(this);
	}

}
