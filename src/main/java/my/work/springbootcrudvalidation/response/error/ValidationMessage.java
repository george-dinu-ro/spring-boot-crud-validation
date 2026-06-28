package my.work.springbootcrudvalidation.response.error;

import lombok.Builder;

@Builder
public record ValidationMessage(String field, String message) {
}
