package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {
    private static Logger logger= LogManager.getLogger(Log4jDemo.class);
    public static void main(String[] args) {
        System.out.println("\n Hello world \n");
        logger.info("this is logger info message");
        logger.debug("this is logger debug message");
        logger.error("this is logger error message");
        logger.fatal("this is logger fatal message");
        logger.warn("warn msg");
        logger.trace("trace msg");
    }
}
