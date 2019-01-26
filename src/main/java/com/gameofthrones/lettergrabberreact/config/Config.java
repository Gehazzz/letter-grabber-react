package com.gameofthrones.lettergrabberreact.config;

import com.github.javafaker.Faker;
import com.github.javafaker.GameOfThrones;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public GameOfThrones faker(){
        return new Faker().gameOfThrones();
    }
}
