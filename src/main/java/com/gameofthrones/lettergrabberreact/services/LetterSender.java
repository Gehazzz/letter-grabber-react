package com.gameofthrones.lettergrabberreact.services;

import com.gameofthrones.lettergrabberreact.model.Letter;
import reactor.core.publisher.Flux;


public interface LetterSender {
    void send(Flux<Letter> letters);
}
