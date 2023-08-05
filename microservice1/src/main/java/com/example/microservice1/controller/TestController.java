package com.example.microservice1.controller;


import com.example.microservice1.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
@RequiredArgsConstructor
public class TestController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public String sendTestEvent(@RequestBody String msg) {
        log.info("Received request with body: {}", msg);
        new Thread(() -> log.info("Hello from child thread!"),"childThread").start();
        kafkaProducer.sendToDefaultTopic(null, msg);
        return "Your msg is: " + msg;
    }
}
