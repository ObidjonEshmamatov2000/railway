package com.mafia.railway_api.config;


import com.mafia.railway_api.exception.connection.ConnectionCustomException;
import com.mafia.railway_api.exception.connection.ConnectionNotFoundException;
import com.mafia.railway_api.exception.railway.RailwayCustomException;
import com.mafia.railway_api.exception.railway.RailwayNotFoundException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionCustomException;
import com.mafia.railway_api.exception.railwayConnection.RailwayConnectionNotFoundException;
import com.mafia.railway_api.exception.ticket.TicketCustomException;
import com.mafia.railway_api.exception.ticket.TicketNotFound;
import com.mafia.railway_api.exception.train.TrainCustomException;
import com.mafia.railway_api.exception.train.TrainNotFoundException;
import com.mafia.railway_api.exception.user.UserCustomException;
import com.mafia.railway_api.exception.user.UserNotFound;
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
    public ResponseEntity<?> handleUserCustomException(UserCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFound e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ConnectionCustomException.class)
    public ResponseEntity<?> handleConnectionCustomException(ConnectionCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(ConnectionNotFoundException.class)
    public ResponseEntity<?> handleConnectionNotFoundException(ConnectionNotFoundException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayCustomException.class)
    public ResponseEntity<?> handleRailwayCustomException(RailwayCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayNotFoundException.class)
    public ResponseEntity<?> handleRailwayNotFoundException(RailwayNotFoundException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayConnectionCustomException.class)
    public ResponseEntity<?> handleRailwayConnectionCustomException(RailwayConnectionCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(RailwayConnectionNotFoundException.class)
    public ResponseEntity<?> handleRailwayConnectionNotFoundException(RailwayConnectionNotFoundException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TicketNotFound.class)
    public ResponseEntity<?> handleTicketNotFoundException(TicketNotFound e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TicketCustomException.class)
    public ResponseEntity<?> handleTicketCustomException(TicketCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<?> handleTrainNotFoundException(TrainNotFoundException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(TrainCustomException.class)
    public ResponseEntity<?> handleTrainCustomException(TrainCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonNotFoundException.class)
    public ResponseEntity<?> handleWagonNotFoundException(WagonNotFoundException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }

    @ExceptionHandler(WagonCustomException.class)
    public ResponseEntity<?> handleWagonCustomException(WagonCustomException e) {
        ApiExceptionErrorResponse apiExceptionErrorResponse = new ApiExceptionErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity.badRequest().body(apiExceptionErrorResponse);
    }
}
