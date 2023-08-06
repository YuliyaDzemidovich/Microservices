package com.example.microservice1.kafka;

import com.example.microservice1.feign.Microservice2Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import static com.example.microservice1.Constants.TRACE_ID;


@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaAsyncListener {

    private final Microservice2Client ms2client;

    @KafkaListener(
            id = "microservice-1-consumer",
            topics = "${kafka.default.topic}",
            autoStartup = "${listen.auto.start:true}",
            concurrency = "${listen.concurrency:3}")
    public void listen(String data, @Header(TRACE_ID) String traceId) {
        MDC.put(TRACE_ID, traceId);
        log.info("Kafka listener - consumed data: {}", data);
        ms2client.sendTestEvent(data);
    }
}
