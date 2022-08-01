package com.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;

@Component
public class MyPostFilter implements GlobalFilter, Ordered {

    Logger logger = LoggerFactory.getLogger(MyPostFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("my last post filter is executed .... ");

        }));
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
