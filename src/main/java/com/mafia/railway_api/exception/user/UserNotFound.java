package com.mafia.railway_api.exception.user;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message) {
        super(message);
    }
    public UserNotFound(String message, Throwable cause) {
        super(message, cause);
    }
    public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
