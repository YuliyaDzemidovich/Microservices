package com.example.microservice1.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

import static com.example.microservice1.Constants.TRACE_ID;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.default.topic}")
    private String defaultTopic;

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    public void sendToDefaultTopic(Integer key, String message) {
        log.info("About to send message to kafka topic={} with key={} and msg={}", defaultTopic, key, message);
        ProducerRecord<Integer, String> producerRecord = new ProducerRecord<>(defaultTopic, key, message);
        producerRecord.headers().add(TRACE_ID, MDC.get(TRACE_ID).getBytes(StandardCharsets.UTF_8));
        kafkaTemplate.send(producerRecord);
        log.info("Sent message to kafka topic={} with key={} and msg={}", defaultTopic, key, message);
    }
}
