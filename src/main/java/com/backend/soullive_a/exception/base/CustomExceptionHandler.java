package com.backend.soullive_a.exception.base;

import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Custom Exception 핸들링
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> onBaseException(BaseException exception) {
        return new ResponseEntity<>(new BaseResponse<>(
                false,
                exception.getErrorCode(),
                exception.getMessage(),
                null),
                null,
                exception.getHttpStatus());
    }

    /**
     * 클라이언트로부터 넘어오는 값 Validation Exception 핸들링
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> onValidationException(Exception exception) {
        return new ResponseEntity<>(new BaseResponse<>(
                false,
                400,
                exception.getMessage(),
                null),
                null,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> onException(Exception exception) {
        return new ResponseEntity<>(new BaseResponse<>(
                false,
                500,
                exception.getMessage(),
                null),
                null,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
