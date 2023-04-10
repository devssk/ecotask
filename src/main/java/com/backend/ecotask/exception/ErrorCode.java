package com.backend.ecotask.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum ErrorCode {
    // 400
    EMPLOYEE_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 직원이 없습니다."),
    MANAGER_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 관리자가 없습니다."),
    DEPARTMENT_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 부서가 없습니다."),
    JOB_NOT_FOUND(HttpStatus.BAD_REQUEST, "해당 직업이 없습니다."),
    EMPLOYEE_ID_IS_NULL(HttpStatus.BAD_REQUEST, "직원 ID가 null 입니다."),
    DEPARTMENT_ID_IS_NULL(HttpStatus.BAD_REQUEST, "부서 ID가 null 입니다."),
    JOB_ID_IS_NULL(HttpStatus.BAD_REQUEST, "직업 ID가 null 입니다."),
    DATE_IS_NULL(HttpStatus.BAD_REQUEST, "날짜가 null 입니다."),
    DATE_IS_NOT_PREVIOUS_DAY(HttpStatus.BAD_REQUEST, "전일(D-1)까지 제공됩니다."),
    YESTERDAY_NOT_AVAILABLE(HttpStatus.BAD_REQUEST, "전일은 11:00 이후 제공됩니다."),
    CHECK_JOB_SALARY(HttpStatus.BAD_REQUEST, "직업별 연봉 하한과 상한을 확인해주세요."),

    // 500
    OPEN_API_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "openapi 응답 실패"),
    OPEN_API_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "openapi 에러")
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }
}
