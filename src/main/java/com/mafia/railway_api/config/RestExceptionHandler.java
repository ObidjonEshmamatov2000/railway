package com.mafia.railway_api.config;

import com.mafia.railway_api.exception.ConnectionCustomException;
import com.mafia.railway_api.exception.ConnectionNotFound;
import com.mafia.railway_api.exception.UserCustomException;
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

    @ExceptionHandler(ConnectionNotFound.class)
    public ResponseEntity<?> handleConnectionNotFoundException() {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), "connection is not found"
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }
}
