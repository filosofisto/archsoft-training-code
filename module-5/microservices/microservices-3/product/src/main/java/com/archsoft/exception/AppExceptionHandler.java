package com.archsoft.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class AppExceptionHandler extends DefaultExceptionHandler {

}
