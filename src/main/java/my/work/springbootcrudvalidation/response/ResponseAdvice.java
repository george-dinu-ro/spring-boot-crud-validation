package my.work.springbootcrudvalidation.response;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import my.work.springbootcrudvalidation.exception.ResourceNotFoundException;
import my.work.springbootcrudvalidation.response.error.ResourceNotFound;
import my.work.springbootcrudvalidation.response.error.ValidationMessage;
import my.work.springbootcrudvalidation.response.error.ValidationResponse;
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
public class ResponseAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ValidationResponse validationResponse(MethodArgumentNotValidException exception) {
        return ValidationResponse.builder()
                .message(getMessage(exception))
                .timestamp(LocalDateTime.now(ZoneOffset.UTC))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ValidationResponse validationResponse(ConstraintViolationException exception) {
        return ValidationResponse.builder()
                .message(getMessage(exception))
                .timestamp(LocalDateTime.now(ZoneOffset.UTC))
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    ResourceNotFound resourceNotFound(ResourceNotFoundException exception) {
        return ResourceNotFound.builder()
                .message(exception.getMessage())
                .timestamp(LocalDateTime.now(ZoneOffset.UTC))
                .build();
    }

    private static List<ValidationMessage> getMessage(MethodArgumentNotValidException exception) {
        var errors = exception.getBindingResult().getFieldErrors();

        return errors.stream()
                .map(ResponseAdvice::getValidationMessage)
                .toList();
    }

    private static ValidationMessage getValidationMessage(FieldError error) {
        return ValidationMessage.builder()
                .field(error.getField())
                .message(error.getDefaultMessage())
                .build();
    }

    private static List<ValidationMessage> getMessage(ConstraintViolationException exception) {
        var errors = exception.getConstraintViolations();

        return errors.stream()
                .map(ResponseAdvice::getValidationMessage)
                .toList();
    }

    private static ValidationMessage getValidationMessage(ConstraintViolation<?> error) {
        var field = error.getPropertyPath().toString();

        return ValidationMessage.builder()
                .field(field.substring(field.lastIndexOf(".") + 1))
                .message(error.getMessage())
                .build();
    }

}



