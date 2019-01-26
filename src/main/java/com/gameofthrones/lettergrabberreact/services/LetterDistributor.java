package com.gameofthrones.lettergrabberreact.services;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface LetterDistributor {
    void distribute();
    void distribute2();

    Mono<ServerResponse> setDelay(ServerRequest serverRequest);
}
