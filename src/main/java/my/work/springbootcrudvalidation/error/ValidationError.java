package my.work.springbootcrudvalidation.error;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ValidationError(List<ValidationMessage> message, LocalDateTime timestamp) {
}

@Builder
record ValidationMessage(String field, String message) {
}
