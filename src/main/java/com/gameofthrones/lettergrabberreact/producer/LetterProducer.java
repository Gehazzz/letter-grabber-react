package com.gameofthrones.lettergrabberreact.producer;

import com.gameofthrones.lettergrabberreact.model.Letter;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface LetterProducer {
    Letter getLetter();

    Mono<ServerResponse> setDelay(ServerRequest serverRequest);
}
