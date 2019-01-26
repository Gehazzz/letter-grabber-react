package com.gameofthrones.lettergrabberreact.routers;

import com.gameofthrones.lettergrabberreact.producer.LetterProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class LetterProducerConfiguratorRouter {
    @Bean
    public RouterFunction<ServerResponse> producerDelay(LetterProducer letterProducer){
        return RouterFunctions.route(GET("/producer/producer-delay/{producerDelay}").and(accept(APPLICATION_JSON)), letterProducer::setDelay);
    }
}
