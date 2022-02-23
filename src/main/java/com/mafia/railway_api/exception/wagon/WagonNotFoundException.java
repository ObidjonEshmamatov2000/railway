package com.mafia.railway_api.exception.wagon;

public class WagonNotFoundException extends RuntimeException{
    protected WagonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WagonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WagonNotFoundException(String message) {
        super(message);
    }
}
