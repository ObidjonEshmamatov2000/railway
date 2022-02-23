package com.mafia.railway_api.exception.ticket;

public class TicketNotFound extends RuntimeException{

    public TicketNotFound(String message) {
        super(message);
    }

    public TicketNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    protected TicketNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
