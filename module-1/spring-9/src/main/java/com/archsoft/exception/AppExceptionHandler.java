package com.archsoft.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
@RestController
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(RecordNotFoundException.class)
//    public void recordNotFound(HttpServletResponse response) throws IOException {
//        response.sendError(NOT_FOUND.value());
//    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ExceptionResponse> recordNotFound(Exception exception, WebRequest webRequest) {
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .date(LocalDateTime.now())
                        .message(exception.getMessage())
                        .status(NOT_FOUND.value())
                        .build(),
                NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(
                ExceptionResponse.builder()
                        .date(LocalDateTime.now())
                        .message("Trocando os metodos HTTP? " + ex.getMessage())
                        .status(METHOD_NOT_ALLOWED.value())
                        .build(),
                METHOD_NOT_ALLOWED);
    }
}
