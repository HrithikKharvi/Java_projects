package com.example;

public class InfoLogger extends Logger{
    public InfoLogger(Logger nextLogger){
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message){
        if(Logger.INFO == logLevel){
            System.out.println("INFO: " + message);
        }else{
            super.log(logLevel, message);
        }
    }
}
