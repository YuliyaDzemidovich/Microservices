package com.example.microservice1.feign;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

public interface Microservice2Client {

    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    void sendTestEvent(@RequestBody String msg);
}
