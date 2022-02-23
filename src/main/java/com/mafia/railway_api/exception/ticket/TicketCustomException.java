package com.mafia.railway_api.exception.ticket;

public class TicketCustomException extends RuntimeException{

    public TicketCustomException(String message) {
        super(message);
    }

    public TicketCustomException(String message, Throwable cause) {
        super(message, cause);
    }



    protected TicketCustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
