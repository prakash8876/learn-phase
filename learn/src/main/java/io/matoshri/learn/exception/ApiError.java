package io.matoshri.learn.exception;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public record ApiError(String path, String message, int httpStatusCode, LocalDateTime timestamp) {
}
