package com.archsoft.exception;

public class CustomerInvalidException extends Exception {

    public CustomerInvalidException() {
        super();
    }

    public CustomerInvalidException(String message) {
        super(message);
    }

    public CustomerInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerInvalidException(Throwable cause) {
        super(cause);
    }
}
