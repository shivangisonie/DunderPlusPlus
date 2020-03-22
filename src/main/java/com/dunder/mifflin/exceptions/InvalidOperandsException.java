package com.dunder.mifflin.exceptions;

public class InvalidOperandsException extends DunderException {
    public InvalidOperandsException() {
        super();
    }

    public InvalidOperandsException(String message) {
        super(message);
    }

    public InvalidOperandsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidOperandsException(Throwable cause) {
        super(cause);
    }

    protected InvalidOperandsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
