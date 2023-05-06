package com.example;

public class Main {

    public static void main(String[] args) {
        Logger logger = new DebugLogger(new ErrorLogger(new InfoLogger(null)));

        logger.log(Logger.INFO, "Info log");
        logger.log(Logger.ERROR, "Error log");
        logger.log(Logger.DEBUG, "Debug log");
    }
}
