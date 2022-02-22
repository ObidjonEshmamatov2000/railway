package com.mafia.railway_api.exception.connection;

public class ConnectionNotFoundException extends RuntimeException{
    protected ConnectionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConnectionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionNotFoundException(String message) {
        super(message);
    }
}
