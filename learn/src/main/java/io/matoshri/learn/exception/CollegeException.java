package io.matoshri.learn.exception;

import org.springframework.stereotype.Component;

@Component
public class CollegeException extends AppRuntimeException {

    public CollegeException() {
    }

    public CollegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollegeException(String message) {
        super(message);
    }
}
