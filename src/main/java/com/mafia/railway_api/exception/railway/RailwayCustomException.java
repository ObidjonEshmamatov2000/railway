package com.mafia.railway_api.exception.railway;


public class RailwayCustomException extends RuntimeException{
    protected RailwayCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RailwayCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public RailwayCustomException(String message) {
        super(message);
    }
}
