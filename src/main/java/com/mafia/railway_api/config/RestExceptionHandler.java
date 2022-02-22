package com.mafia.railway_api.config;

import com.mafia.railway_api.exception.*;
import com.mafia.railway_api.exception.connection.ConnectionCustomException;
import com.mafia.railway_api.exception.connection.ConnectionNotFoundException;
import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.railway.RailwayNotFoundException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionCustomException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionNotFoundException;
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

    @ExceptionHandler(ConnectionCustomException.class)
    public ResponseEntity<?> handleConnectionCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "connection is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayCustomException.class)
    public ResponseEntity<?> handleRailwayCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "railway is exist"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayConnectionCustomException.class)
    public ResponseEntity<?> handleRailwayConnectionCustomException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "railway connection is exist"
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

    @ExceptionHandler(RailwayNotFoundException.class)
    public ResponseEntity<?> handleRailwayNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "railway is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayConnectionNotFoundException.class)
    public ResponseEntity<?> handleRailwayConnectionNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "railway connection is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }
}
