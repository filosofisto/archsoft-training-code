package com.archsoft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
}
