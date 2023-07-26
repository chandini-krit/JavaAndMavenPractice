package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggerExample {
    private static final Logger log =LoggerFactory.getLogger(LoggerExample.class);

    public static void process(String input){
        log.debug("this is debug message {}",input);
//        log.info("This is an info message");
//        log.warn("This is a warning message");
//        log.error("This is an error message");
    }
}
