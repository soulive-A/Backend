package com.backend.soullive_a.exception.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    // 성공
    SUCCESS(true, 1000, "요청에 성공했습니다.", HttpStatus.OK),

    //실패 - 필요시 만들어 쓰세요
    /**
     * 2000 : User 오류
     */
    NOT_FOUND_USER(false, 2001, "사용자를 찾을 수 없습니다", HttpStatus.NOT_FOUND);

    private final boolean isSuccess;
    private final int code;
    private final String message;
    private final HttpStatus httpStatus;

    ErrorCode(boolean isSuccess, int code, String message, HttpStatus httpStatus) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}

