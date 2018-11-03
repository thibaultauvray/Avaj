package com.avaj.simulator;

import com.avaj.logger.LoggerSimulation;
import com.avaj.simulator.vehicles.AircraftFactory;
import com.avaj.simulator.vehicles.Flyable;
import com.avaj.exceptions.EmptyArgumentException;
import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.*;
import java.util.logging.LogManager;

public class Simulator {


	private static int getNumber(String string){
		if (string.matches("-?(0|[1-9]\\d*)")) {
			int iteration = Integer.parseInt(string);
			if (iteration < 0){
				throw new IllegalArgumentException("Number must be a positive number");
			}
			return iteration;
		} else {
			throw new IllegalArgumentException("Must be a number");
		}

	}

    public static void main(String[] args) {
	
    	try {
			if (args.length == 0){
				throw new EmptyArgumentException("You must specify a filename in arguments");
			}
			WeatherTower weatherTower = new WeatherTower();
    		List<Flyable> flyableList = new ArrayList<>();
			File file = new File(args[0]);

			boolean firstLine = true;
			int iteration = 0;
			BufferedReader reader = new BufferedReader(new FileReader(file));
			LoggerSimulation.setup();
			String line;

			while ((line = reader.readLine()) != null) {
				if (firstLine) {
					iteration = Simulator.getNumber(line.trim());
					firstLine = false;
				}
				else {
					String[] airCraft = line.split(" ");
					if (airCraft.length != 5 ){
						throw new IllegalArgumentException("Invalid file");
					}
					Flyable flyable = AircraftFactory.newAircraft(airCraft[0].trim(), airCraft[1].trim(), Simulator.getNumber(airCraft[2].trim()), Simulator.getNumber(airCraft[3].trim()), Simulator.getNumber(airCraft[4].trim()));
					flyableList.add(flyable);
				}
			}

			for (Flyable flyable : flyableList){
				flyable.registerTower(weatherTower);
			}

			for (int i = 0; i < iteration; i++){
				weatherTower.changeWeather();
			}

			reader.close();
		}
		catch(IllegalArgumentException | EmptyArgumentException | IOException e){
    		System.out.println(e.getMessage());
		}
		catch (Exception e){
    		System.out.println("Unknown error");
		}finally {
			LogManager.getLogManager().reset();
		}
    }
}
