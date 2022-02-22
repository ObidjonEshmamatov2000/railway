package com.mafia.railway_api.exception.railwayConnection;

public class RailwayConnectionNotFoundException extends RuntimeException{
    protected RailwayConnectionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RailwayConnectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RailwayConnectionNotFoundException(String message) {
        super(message);
    }
}
