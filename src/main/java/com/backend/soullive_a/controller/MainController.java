package com.backend.soullive_a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/health")
    public String apiTest() {
        System.out.println("health-check!");
        return "health check! v2.";
    }
}

