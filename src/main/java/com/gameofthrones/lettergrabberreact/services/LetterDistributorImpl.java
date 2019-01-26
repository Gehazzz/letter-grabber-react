package com.gameofthrones.lettergrabberreact.services;

import com.gameofthrones.lettergrabberreact.model.Letter;
import com.gameofthrones.lettergrabberreact.producer.LetterProducer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@RequiredArgsConstructor
@Service
@Slf4j
public class LetterDistributorImpl implements LetterDistributor {
    private final LetterProducer producer;
    private final LetterSender sender;

    private int delay=1;

    @SneakyThrows
    @Override
    public void distribute() {
        Flux<Letter> letters = Flux.<Letter>create(fluxSink -> {
            int i = 0;
            while (true){
                i++;
                sleep(this.delay);
                fluxSink.next(producer.getLetter());
            }
        }).share();
        sender.send(letters);
    }

    @SneakyThrows
    @Override
    public void distribute2() {
        Flux.<Letter>generate(fluxSink -> {
                sleep(this.delay);
                fluxSink.next(producer.getLetter());
        }).parallel().runOn(Schedulers.parallel()).groups().doOnNext(integerLetterGroupedFlux -> {
            Flux<Letter> pLetters = integerLetterGroupedFlux.share();
            sender.send(pLetters);
            log.info(Thread.currentThread().toString());
        }).subscribe();
    }

    @Override
    public Mono<ServerResponse> setDelay(ServerRequest serverRequest) {
        this.delay  = Integer.parseInt(serverRequest.pathVariable("delay"));
        return ServerResponse.ok().build();
    }

    @SneakyThrows
    private void sleep(int delay){
        Thread.sleep(delay);
    }
}
