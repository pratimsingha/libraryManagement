package com.kaha.library.exceptions;

public class GlobalException extends RuntimeException {
    public GlobalException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
