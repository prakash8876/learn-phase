package io.matoshri.learn.exception;

public class AppIllegalArgumentException extends IllegalArgumentException {
    public AppIllegalArgumentException() {
    }

    public AppIllegalArgumentException(String s) {
        super(s);
    }

    public AppIllegalArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppIllegalArgumentException(Throwable cause) {
        super(cause);
    }
}
