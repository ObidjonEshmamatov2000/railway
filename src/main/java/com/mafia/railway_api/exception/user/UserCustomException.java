package com.mafia.railway_api.exception.user;


public class UserCustomException extends RuntimeException{

    protected UserCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UserCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserCustomException(String message) {
        super(message);
    }
}
