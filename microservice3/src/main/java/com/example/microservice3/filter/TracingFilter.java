package com.example.microservice3.filter;

import com.example.microservice3.util.Utils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.example.microservice3.Constants.TRACE_ID;
import static com.example.microservice3.Constants.X_REQUEST_ID;

@Component
public class TracingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String traceId = Utils.getOrGenerateFlowId(request.getHeader(X_REQUEST_ID));
        MDC.put(TRACE_ID, traceId);
        response.addHeader(X_REQUEST_ID, traceId);
        filterChain.doFilter(request, response);
    }
}

