package com.example.microservice1.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.default.topic}")
    private String defaultTopic;

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public void sendToDefaultTopic(Integer key, String message) {
        log.info("About to send message to kafka topic={} with key={} and msg={}", defaultTopic, key, message);
        kafkaTemplate.send(defaultTopic, key, message);
        log.info("Sent message to kafka topic={} with key={} and msg={}", defaultTopic, key, message);
    }
}
