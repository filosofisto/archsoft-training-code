package com.archsoft.exception;

public class ProductNotAvailable extends Exception {
    public ProductNotAvailable() {
        super();
    }

    public ProductNotAvailable(String message) {
        super(message);
    }

    public ProductNotAvailable(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotAvailable(Throwable cause) {
        super(cause);
    }
}
