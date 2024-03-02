package com.backend.soullive_a.exception.base;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseException extends RuntimeException {

    private final int errorCode;
    private final String message;
    private final HttpStatus httpStatus;

    public BaseException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.httpStatus = errorCode.getHttpStatus();
    }

    public BaseException(ErrorCode errorCode, String message) {
        super();
        this.errorCode = errorCode.getCode();
        this.message = message;
        this.httpStatus = errorCode.getHttpStatus();
    }
}