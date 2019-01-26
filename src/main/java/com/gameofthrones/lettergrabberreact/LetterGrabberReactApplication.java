package com.gameofthrones.lettergrabberreact;

import com.gameofthrones.lettergrabberreact.services.LetterDistributor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class LetterGrabberReactApplication {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext context = SpringApplication.run(LetterGrabberReactApplication.class, args);
        LetterDistributor distributor = context.getBean(LetterDistributor.class);
        distributor.distribute2();
    }

}

