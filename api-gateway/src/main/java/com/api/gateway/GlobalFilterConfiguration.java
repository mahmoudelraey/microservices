package com.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalFilterConfiguration {

    Logger logger = LoggerFactory.getLogger(GlobalFilterConfiguration.class);

    @Order(1)
    @Bean
    public GlobalFilter secondFilter() {
        return ((exchange, chain) -> {
            logger.info("my second pre filter is executed .... ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("my third post filter is executed .... ");
            }));
        });
    }

    @Order(2)
    @Bean
    public GlobalFilter thirdFilter() {
        return ((exchange, chain) -> {
            logger.info("my third pre filter is executed .... ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("my second post filter is executed .... ");
            }));
        });
    }

    @Order(3)
    @Bean
    public GlobalFilter fourthFilter() {
        return ((exchange, chain) -> {
            logger.info("my fourth pre filter is executed .... ");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("my first post filter is executed .... ");
            }));
        });
    }
}
