package io.matoshri.learn.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollegeException extends AppRuntimeException {

    @Autowired
    public CollegeException() {
        super();
    }

    public CollegeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CollegeException(String message) {
        super(message);
    }
}
