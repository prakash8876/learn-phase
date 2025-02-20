package io.matoshri.learn.exception;

import java.time.LocalDateTime;

public record ApiError(String path, String message, int httpStatusCode, LocalDateTime timestamp) {
}
