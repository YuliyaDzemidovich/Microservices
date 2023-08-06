package com.example.microservice2.interceptors;

import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

import static com.example.microservice2.Constants.TRACE_ID;
import static com.example.microservice2.Constants.X_REQUEST_ID;

public class RestTemplateTracingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        String traceIdFromLogs = MDC.get(TRACE_ID);
        if (traceIdFromLogs != null) {
            request.getHeaders().add(X_REQUEST_ID, traceIdFromLogs);
        }
        return execution.execute(request, body);
    }
}
