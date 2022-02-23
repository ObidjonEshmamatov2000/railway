package com.mafia.railway_api.exception.train;

public class TrainNotFoundException extends RuntimeException{
    protected TrainNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TrainNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainNotFoundException(String message) {
        super(message);
    }
}
