package com.chiraranw.gitviewscommandservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GitViewsCommandServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitViewsCommandServiceApplication.class, args);
    }


    @Bean
    WebClient.Builder getClient(){
        return WebClient.builder();
    }
}
