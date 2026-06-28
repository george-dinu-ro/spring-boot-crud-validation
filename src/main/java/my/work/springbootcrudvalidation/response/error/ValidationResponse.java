package my.work.springbootcrudvalidation.response.error;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record ValidationResponse(List<ValidationMessage> message, LocalDateTime timestamp) {

}
