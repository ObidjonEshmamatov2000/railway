package com.mafia.railway_api.exception.train;


public class TrainCustomException extends RuntimeException{
    protected TrainCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TrainCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrainCustomException(String message) {
        super(message);
    }
}
