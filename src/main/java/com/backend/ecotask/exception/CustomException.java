package com.backend.ecotask.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException{

    private final ErrorCode errorCode;

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
