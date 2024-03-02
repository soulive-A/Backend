package com.backend.soullive_a.exception.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
@NoArgsConstructor
public class BaseResponse<T> {

    private boolean isSuccess;
    private int code;
    private String message;
    private T data;

    @Builder
    public BaseResponse(boolean isSuccess, int code, String message, T data) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
