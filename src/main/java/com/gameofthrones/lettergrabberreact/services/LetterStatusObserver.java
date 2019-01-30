package com.gameofthrones.lettergrabberreact.services;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface LetterStatusObserver {
    Mono<ServerResponse> updateStatus(ServerRequest serverRequest);
}
