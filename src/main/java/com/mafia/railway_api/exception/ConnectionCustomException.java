package com.mafia.railway_api.exception;


public class ConnectionCustomException extends RuntimeException{
    protected ConnectionCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConnectionCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionCustomException(String message) {
        super(message);
    }
}
