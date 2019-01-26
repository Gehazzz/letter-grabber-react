package com.gameofthrones.lettergrabberreact.config;

import com.github.javafaker.Faker;
import com.github.javafaker.GameOfThrones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {
    @Bean
    public GameOfThrones faker(){
        return new Faker().gameOfThrones();
    }

    @Bean
    public WebClient webClient(){
        return  WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }
}
