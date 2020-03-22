package com.dunder.mifflin.exceptions;

/**
 * Dunder Exception is a checked exception.
 * For unchecked exception use MifflinException.
 */
public class DunderException extends Exception {
    public DunderException() {
        super();
    }

    public DunderException(String message) {
        super(message);
    }

    public DunderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DunderException(Throwable cause) {
        super(cause);
    }

    protected DunderException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
