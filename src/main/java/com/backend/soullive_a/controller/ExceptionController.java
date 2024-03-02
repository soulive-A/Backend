package com.backend.soullive_a.controller;

import com.backend.soullive_a.entity.User;
import com.backend.soullive_a.exception.base.BaseResponse;
import com.backend.soullive_a.exception.custom.NotFoundUserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
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
    /*
     * @AuthenticationPrincipal 사용법 예시
     */
    @GetMapping("/test")
    public String test(@AuthenticationPrincipal User user){
        log.info("user 아이디 값: {}",user.getId());
        return "test";
    }
}