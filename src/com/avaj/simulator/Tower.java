package com.avaj.simulator;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

import com.avaj.simulator.vehicles.Flyable;

public class Tower
{
    private Collection<Flyable> observers = new CopyOnWriteArrayList<Flyable>();
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);


    public void register(Flyable flyable)
    {
    	this.observers.add(flyable);
        LOGGER.info("Tower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "("+ flyable.getId() + ") registered to weather tower.");
    }

    public void unregister(Flyable flyable)
    {
        LOGGER.info("Tower says: " + flyable.getClass().getSimpleName() + "#" + flyable.getName() + "("+ flyable.getId() + ")  unregistered from weather tower.");
        this.observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        Iterator<Flyable> it = observers.iterator();
        while (it.hasNext()) {
            Flyable flyable = it.next();

            flyable.updateConditions();

            if (flyable.getCoordinates().getHeight() == 0){
                LOGGER.info(flyable.getClass().getSimpleName() + "#" + flyable.getName() + "("+ flyable.getId() + ") landing.");
                this.unregister(flyable);
            }
        }
    }
}
