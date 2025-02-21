package io.matoshri.learn.exception;

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
