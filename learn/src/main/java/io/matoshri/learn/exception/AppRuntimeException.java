package io.matoshri.learn.exception;

import org.springframework.stereotype.Component;

@Component
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
