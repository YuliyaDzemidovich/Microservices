package com.example.microservice2.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<String> sendTestEvent(@RequestBody String msg) {
        log.info("Received request with body: {}", msg);
        new Thread(() -> log.info("Hello from child thread!"),"childThread").start();
        HttpEntity<String> httpEntity = new HttpEntity<>(msg);
        return restTemplate.exchange("http://localhost:8082/test", HttpMethod.POST, httpEntity, String.class);
    }
}
