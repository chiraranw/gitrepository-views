package com.chiraranw.gitviewscommandservice.service;

import com.chiraranw.gitviewscommandservice.model.GitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
public class GitHubAPIService {

    private final WebClient.Builder client;

    @Autowired
    public GitHubAPIService(@Qualifier("getClient") WebClient.Builder client) {
        this.client = client;
    }

    public Optional<GitRepository> getRepoDetails(String login){
        System.out.println("making the call");
        return  this.client
                .build()
                .get()
                .uri("https://api.github.com/users/" + login + "/repos")
                .retrieve()
                .bodyToFlux(GitRepository.class)
                .toStream()
                .findFirst();
    }

}
