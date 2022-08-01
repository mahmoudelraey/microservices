package com.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class MyPreFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("my first pre filter is executed .... ");

        ServerHttpRequest serverHttpRequest = exchange.getRequest();

        String requestPath = serverHttpRequest.getPath().toString();
        logger.info("Request Path: " + requestPath);

        HttpHeaders httpHeaders = serverHttpRequest.getHeaders();
        Set<String> headerKeys = httpHeaders.keySet();
        headerKeys.stream().forEach(headerKey -> {

            String headerValue = httpHeaders.getFirst(headerKey);
            logger.info(headerKey + " : " + headerValue);
        });
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
