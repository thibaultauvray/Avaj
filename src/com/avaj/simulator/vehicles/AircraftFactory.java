package com.avaj.simulator.vehicles;

import com.avaj.weather.Coordinates;
import com.avaj.logger.LoggerSimulation;

import java.io.IOException;
import java.util.logging.Logger;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
		switch(type){
		case "Helicopter":
			return new Helicopter(name, new Coordinates(longitude, latitude, height));
		case "JetPlane":
			return new JetPlane(name, new Coordinates(longitude, latitude, height));
		case "Baloon":
			return new Baloon(name, new Coordinates(longitude, latitude, height));
		default:
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        }
	}

}
