package io.matoshri.learn.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentException extends AppRuntimeException {

    @Autowired
    public StudentException() {
        super();
    }

    public StudentException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentException(String message) {
        super(message);
    }
}
