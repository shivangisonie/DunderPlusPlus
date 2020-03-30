package com.dunder.mifflin.exceptions;

/**
 * Mifflin Exception is an unchecked exception.
 * For checked exceptions use DunderException.
 */
public class MifflinException extends RuntimeException {
    private static final long serialVersionUID = 4446793865034784757L;

    public MifflinException() {
        super();
    }

    public MifflinException(String message) {
        super(message);
    }

    public MifflinException(String message, Throwable cause) {
        super(message, cause);
    }

    public MifflinException(Throwable cause) {
        super(cause);
    }

    protected MifflinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
