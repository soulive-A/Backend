package com.backend.soullive_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/api")
    public String apiTest() {
        System.out.println("@@@");
        return "commit test";
    }
}
