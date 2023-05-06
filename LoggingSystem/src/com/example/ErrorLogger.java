package com.example;

public class ErrorLogger extends Logger{

    public ErrorLogger(Logger nextLogger){
        super(nextLogger);
    }

    @Override
    public void log(int logLevel, String message){
        if(logLevel == Logger.ERROR){
            System.out.println("ERROR : " + message);
        }else{
            super.log(logLevel, message);
        }
    }

}
