package com.gateway.apigateway.filter.global;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class LoggerFilter extends AbstractGatewayFilterFactory<LoggerFilter.Config> {

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            if( config.isPreLogger ) {
                log.info( "requset info - request uri : {}", request.getURI() );
                log.info( "requset info - request method : {}", request.getMethod() );
                log.info( "requset info - request Cookie : {}", request.getCookies() );
                log.info( "requset info - request path : {}", request.getPath() );
            }

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                if( config.isPostLogger ) {
                    log.info( " response info - response status code : {}", response.getStatusCode() );
                    log.info( " response info - response Cookie : {}", response.getCookies() );
                }
            }));
        });
    }

    static class Config {
        private boolean isPreLogger;
        private boolean isPostLogger;
    }
}
