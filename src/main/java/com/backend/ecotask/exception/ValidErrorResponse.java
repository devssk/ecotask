package com.backend.ecotask.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Builder
public class ValidErrorResponse {

    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    private final int status;
    private final String error;
    private final String message;

    public static ResponseEntity<ValidErrorResponse> responseEntity(ConstraintViolationException e) {
        return ResponseEntity
                .status(400)
                .body(ValidErrorResponse.builder()
                        .status(400)
                        .error(HttpStatus.BAD_REQUEST.name())
                        .message(e.getMessage())
                        .build());
    }
}
