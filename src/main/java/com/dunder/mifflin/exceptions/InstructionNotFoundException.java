package com.dunder.mifflin.exceptions;

public class InstructionNotFoundException extends DunderException {
    private static final long serialVersionUID = 7519067956414717084L;

    public InstructionNotFoundException() {
        super();
    }

    public InstructionNotFoundException(String message) {
        super(message);
    }

    public InstructionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InstructionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected InstructionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
