package com.mafia.railway_api.config;



import com.mafia.railway_api.exception.connection.ConnectionCustomException;
import com.mafia.railway_api.exception.connection.ConnectionNotFoundException;

import com.mafia.railway_api.exception.ticket.TicketCustomException;
import com.mafia.railway_api.exception.ticket.TicketNotFound;
import com.mafia.railway_api.exception.user.UserCustomException;
import com.mafia.railway_api.exception.user.UserNotFound;

import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.railway.RailwayNotFoundException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionCustomException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionNotFoundException;
import com.mafia.railway_api.exception.train.TrainCustomException;
import com.mafia.railway_api.exception.train.TrainNotFoundException;
import com.mafia.railway_api.exception.wagon.WagonCustomException;
import com.mafia.railway_api.exception.wagon.WagonNotFoundException;
import com.mafia.railway_api.model.response.ApiExceptionErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), ex.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }


    @ExceptionHandler(UserCustomException.class)
    public ResponseEntity<?> handleUserCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "user is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> handleUserNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "user not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ConnectionCustomException.class)
    public ResponseEntity<?> handleConnectionCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "connection is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ConnectionNotFoundException.class)
    public ResponseEntity<?> handleConnectionNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "connection is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TicketNotFound.class)
    public ResponseEntity<?> handleTicketNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "ticket is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TicketCustomException.class)
    public ResponseEntity<?> handleTicketCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "ticket is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<?> handleTrainNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "train is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainCustomException.class)
    public ResponseEntity<?> handleTrainCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "train is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonNotFoundException.class)
    public ResponseEntity<?> handleWagonNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "wagon is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonCustomException.class)
    public ResponseEntity<?> handleWagonCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "wagon is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonNotFoundException.class)
    public ResponseEntity<?> handleWagonNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "wagon is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonCustomException.class)
    public ResponseEntity<?> handleWagonCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "wagon is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<?> handleTrainNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "train is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainCustomException.class)
    public ResponseEntity<?> handleTrainCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "train is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }
}
