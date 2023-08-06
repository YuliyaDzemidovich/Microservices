package com.example.microservice1.feign;

import feign.Feign;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Microservice2Client getFeignClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .requestInterceptor(new FeignRequestInterceptor())
                .target(Microservice2Client.class, "http://localhost:8081/test");
    }
}
