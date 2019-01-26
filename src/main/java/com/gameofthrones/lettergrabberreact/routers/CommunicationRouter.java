package com.gameofthrones.lettergrabberreact.routers;

import com.gameofthrones.lettergrabberreact.services.LetterDistributor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Component
public class CommunicationRouter {
    @Bean
    public RouterFunction<ServerResponse> delay(LetterDistributor letterDistributor){
        return RouterFunctions.route(GET("/distribution/read-delay/{delay}").and(accept(APPLICATION_JSON)), letterDistributor::setDelay);
    }
}
