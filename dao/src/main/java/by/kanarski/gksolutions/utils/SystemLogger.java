package by.kanarski.gksolutions.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SystemLogger {

    private static SystemLogger instance;
    private Logger logger;
    private Class sender;

    private SystemLogger() {
    }

    public static synchronized SystemLogger getInstance() {
        if (instance == null) {
            instance = new SystemLogger();
        }
        return instance;
    }

    public SystemLogger setSender(Class sender) {
        this.sender = sender;
        return instance;
    }

    public void logError(Class sender, String message, Throwable error) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(message, error);
    }

    public void logError(Class sender, String message) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(message);
    }

    public void logError(Class sender, Throwable error) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(error.getMessage(), error);
    }


    public void logError(String message, Throwable error) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(message, error);
    }

    public void logError(Throwable error) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(error.getMessage(), error);
    }

    public void logError(String message) {
        logger = LoggerFactory.getLogger(sender);
        logger.error(message);
    }

    public void logInfo(Class sender, String message) {
        logger = LoggerFactory.getLogger(sender);
        logger.info(message);
    }

    public void logInfo(String message) {
        logger = LoggerFactory.getLogger(sender);
        logger.info(message);
    }

}