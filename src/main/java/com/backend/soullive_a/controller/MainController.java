package com.backend.soullive_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api")
    public String apiTest() {
        System.out.println("@@@");
        return "감사합니다.이것이 cicd이다 쏘울라이브 버전";
    }
}
