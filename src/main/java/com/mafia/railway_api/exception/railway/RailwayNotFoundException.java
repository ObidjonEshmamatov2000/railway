package com.mafia.railway_api.exception.railway;

public class RailwayNotFoundException extends RuntimeException{
    protected RailwayNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RailwayNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RailwayNotFoundException(String message) {
        super(message);
    }
}
