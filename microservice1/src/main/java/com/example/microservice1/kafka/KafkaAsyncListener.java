package com.example.microservice1.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaAsyncListener {

    @KafkaListener(id = "KafkaAsyncListener", topics = "${kafka.default.topic}",
            autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void listen(String data) {
        log.info("Kafka listener - consumed data: {}", data);
    }
}
