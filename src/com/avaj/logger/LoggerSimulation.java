package com.avaj.logger;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSimulation {

    static public void setup() throws IOException {

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.INFO);
        FileHandler fileTxt = new FileHandler("simulation.txt");

        FormatterSimulator formatterTxt = new FormatterSimulator();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
    }
}