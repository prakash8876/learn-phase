package io.matoshri.learn.exception;

public class AppRuntimeException extends RuntimeException {

    public AppRuntimeException() {
    }

    public AppRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppRuntimeException(String message) {
        super(message);
    }
}
