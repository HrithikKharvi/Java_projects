package com.example;

public class Logger {

    private Logger nextLogger;
    public static int ERROR = 1;
    public static int DEBUG = 2;
    public static int INFO = 3;

    public Logger(Logger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void log(int logLevel, String message){
        this.nextLogger.log(logLevel, message);
    }

}
