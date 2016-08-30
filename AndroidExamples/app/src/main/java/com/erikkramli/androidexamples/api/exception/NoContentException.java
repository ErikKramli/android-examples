package com.erikkramli.androidexamples.api.exception;

public class NoContentException extends ApiException {

    public NoContentException(String msg) {
        super(msg);
    }

    public NoContentException(String msg, Throwable originalThrowable) {
        super(msg, originalThrowable);
    }
}
