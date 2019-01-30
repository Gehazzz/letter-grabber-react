package com.gameofthrones.lettergrabberreact.routers;

import com.gameofthrones.lettergrabberreact.services.LetterDistributor;
import com.gameofthrones.lettergrabberreact.services.LetterStatusObserver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Component
public class CommunicationRouter {
    @Bean
    public RouterFunction<ServerResponse> delay(LetterDistributor letterDistributor){
        return RouterFunctions.route(GET("/distribution/read-delay/{delay}").and(accept(APPLICATION_JSON)), letterDistributor::setDelay);
    }

    @Bean
    public RouterFunction<ServerResponse> updateLetterStatus(LetterStatusObserver observer){
        return RouterFunctions.route(POST("/letter-status").and(contentType(APPLICATION_JSON)), observer::updateStatus);
    }
}
