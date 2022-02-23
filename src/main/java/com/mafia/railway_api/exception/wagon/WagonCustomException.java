package com.mafia.railway_api.exception.wagon;


public class WagonCustomException extends RuntimeException{
    protected WagonCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WagonCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public WagonCustomException(String message) {
        super(message);
    }
}
