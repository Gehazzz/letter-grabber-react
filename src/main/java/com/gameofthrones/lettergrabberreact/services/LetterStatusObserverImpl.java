package com.gameofthrones.lettergrabberreact.services;

import com.gameofthrones.lettergrabberreact.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class LetterStatusObserverImpl implements LetterStatusObserver{

    private Map<String, Notification> statuses = new HashMap<>();

    @Override
    public Mono<ServerResponse> updateStatus(ServerRequest serverRequest) {
        Mono<Void> result = serverRequest.bodyToMono(Notification.class)
                .doOnNext(notification -> {
                    statuses.put(notification.getLetterId(), notification);
                    log.info("We got notification about letter with id: " + notification.getLetterId() + " message is " + notification.getMessage());
                }).then();
        return ServerResponse.ok().build(result);
    }
}
