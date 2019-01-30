package com.gameofthrones.lettergrabberreact.producer;

import com.gameofthrones.lettergrabberreact.model.Letter;
import com.github.javafaker.GameOfThrones;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LetterProducerFake implements LetterProducer {
    private final GameOfThrones faker;

    private int delay=2000;

    @Override
    @SneakyThrows
    public Letter getLetter() {
        Thread.sleep(delay);
        return randomLetter();
    }

    @Override
    public Mono<ServerResponse> setDelay(ServerRequest serverRequest) {
        this.delay  = Integer.parseInt(serverRequest.pathVariable("producerDelay"));
        return ServerResponse.ok().build();
    }

    private Letter randomLetter(){
        return Letter.builder().id(UUID.randomUUID().toString()).content(faker.quote()).location(faker.city()).signature(faker.character()).build();
    }







}
