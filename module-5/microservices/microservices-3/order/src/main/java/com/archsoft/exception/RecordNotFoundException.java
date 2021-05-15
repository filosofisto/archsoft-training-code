package com.archsoft.exception;

public class RecordNotFoundException extends Exception {

    private static final long serialVersionUID = 9216993576619307601L;

    public RecordNotFoundException() {
    }

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }
}
