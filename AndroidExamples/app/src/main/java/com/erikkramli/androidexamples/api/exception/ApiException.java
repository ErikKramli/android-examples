package com.erikkramli.androidexamples.api.exception;

public class ApiException extends Exception {

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, Throwable originalThrowable) {
        super(msg, originalThrowable);
    }
}
