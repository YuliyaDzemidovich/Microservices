package com.example.microservice3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @PostMapping
    public String sendTestEvent(@RequestBody String msg) {
        log.info("Received request with body: {}", msg);
        new Thread(() -> log.info("Hello from child thread!"),"childThread").start();
        return "Your msg is: " + msg;
    }
}