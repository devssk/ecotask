package com.backend.ecotask.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    protected ResponseEntity<ValidErrorResponse> handleValidException(ConstraintViolationException e) {
        log.error("Valid Error, " + e.getMessage());
        return ValidErrorResponse.responseEntity(e);
    }

    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error(e.getErrorCode().name() + ", " + e.getErrorCode().getMessage());
        return ErrorResponse.responseEntity(e.getErrorCode());
    }

}
