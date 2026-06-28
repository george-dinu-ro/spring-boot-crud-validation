package my.work.springbootcrudvalidation.error;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestControllerAdvice
public class ErrorResponse {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ValidationError validateFallback(MethodArgumentNotValidException exception) {
        return ValidationError.builder()
                .message(getMessage(exception))
                .timestamp(LocalDateTime.now(ZoneOffset.UTC))
                .build();
    }

    private static List<ValidationMessage> getMessage(MethodArgumentNotValidException exception) {
        var errors = exception.getBindingResult().getFieldErrors();

        return errors.stream()
                .map(ErrorResponse::getValidationMessage)
                .toList();
    }

    private static ValidationMessage getValidationMessage(FieldError error) {
        return ValidationMessage.builder()
                .field(error.getField())
                .message(error.getDefaultMessage())
                .build();
    }

}



