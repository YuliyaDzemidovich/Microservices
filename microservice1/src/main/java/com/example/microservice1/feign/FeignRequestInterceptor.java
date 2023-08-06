package com.example.microservice1.feign;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.MDC;

import static com.example.microservice1.Constants.TRACE_ID;
import static com.example.microservice1.Constants.X_REQUEST_ID;

public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String traceId = MDC.get(TRACE_ID);
        if (traceId != null) {
            requestTemplate.header(X_REQUEST_ID, traceId);
        }
    }
}