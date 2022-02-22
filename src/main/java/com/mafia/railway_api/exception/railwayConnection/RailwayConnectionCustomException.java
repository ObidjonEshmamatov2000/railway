package com.mafia.railway_api.exception.railwayConnection;


public class RailwayConnectionCustomException extends RuntimeException{
    protected RailwayConnectionCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RailwayConnectionCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public RailwayConnectionCustomException(String message) {
        super(message);
    }
}
