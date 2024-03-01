package com.backend.soullive_a.controller;

import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @GetMapping("/success")
    public BaseResponse<Object> getUser() {
        return BaseResponse.builder()
                .isSuccess(true)
                .code(200)
                .message("사용자를 찾았습니다")
                .data("somin")
                .build();
    }

    @GetMapping("/fail")
    public BaseResponse<Object> notFoundUser() {
        throw new NotFoundUserException();
    }
}