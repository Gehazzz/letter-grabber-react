package com.gameofthrones.lettergrabberreact.services;

import com.gameofthrones.lettergrabberreact.model.Letter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;


@Service
@RequiredArgsConstructor
@Slf4j
public class LetterSenderImpl implements LetterSender {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8081")
            .build();

    public void send(Flux<Letter> letter) {
       /* letter.doOnEach(signal -> {
            System.out.println(signal);
        }).subscribe();*/

        webClient.post().uri("/analyse/letter")
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(letter, Letter.class)
                .retrieve().bodyToMono(Void.class).subscribeOn(Schedulers.parallel()).subscribe();
    }
}