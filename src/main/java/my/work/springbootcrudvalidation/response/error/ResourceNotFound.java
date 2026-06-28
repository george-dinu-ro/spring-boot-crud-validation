package my.work.springbootcrudvalidation.response.error;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResourceNotFound(String message, LocalDateTime timestamp) {
}
