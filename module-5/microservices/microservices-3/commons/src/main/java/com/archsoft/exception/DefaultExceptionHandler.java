package com.archsoft.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

//@ControllerAdvice
//@RestController
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionResponse> recordNotFound(Exception exception, WebRequest webRequest) {
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .date(LocalDateTime.now())
                        .message(exception.getMessage())
                        .status(NOT_FOUND.value())
                        .exception(exception.getClass().getName())
                        .build(),
                NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> genericException(Exception exception, WebRequest webRequest) {
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .date(LocalDateTime.now())
                        .message("Sorry, have no idea what is going on :(")
                        .status(INTERNAL_SERVER_ERROR.value())
                        .exception(exception.getClass().getName())
                        .build(),
                INTERNAL_SERVER_ERROR);
    }
}
