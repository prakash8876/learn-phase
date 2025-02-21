package io.matoshri.learn.exception;

public class StudentException extends AppRuntimeException {

    public StudentException() {
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(String message) {
        super(message);
    }
}
