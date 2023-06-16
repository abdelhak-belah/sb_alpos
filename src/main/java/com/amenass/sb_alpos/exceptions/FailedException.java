package com.amenass.sb_alpos.exceptions;

public class FailedException extends RuntimeException{
    public FailedException(String message) {
        super(message);
    }

    public FailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
