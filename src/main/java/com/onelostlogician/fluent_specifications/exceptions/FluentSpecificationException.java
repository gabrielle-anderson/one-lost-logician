package com.onelostlogician.fluent_specifications.exceptions;

public class FluentSpecificationException extends RuntimeException {
    public FluentSpecificationException() {
    }

    public FluentSpecificationException(String message) {
        super(message);
    }

    public FluentSpecificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FluentSpecificationException(Throwable cause) {
        super(cause);
    }

    public FluentSpecificationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
