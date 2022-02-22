package com.mafia.railway_api.exception;

public class ConnectionNotFound extends RuntimeException{
    protected ConnectionNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConnectionNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionNotFound(String message) {
        super(message);
    }
}
