package com.chiraranw.gitviewsqueryservice.service;

import com.chiraranw.gitviewsqueryservice.model.GitHubUser;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class GitHubUserService {

    private final Logger log= LoggerFactory.getLogger(GitHubUserService.class);

    private final QueryGateway queryGateway;

    @Autowired
    public GitHubUserService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    public CompletableFuture<List<GitHubUser>> getAll(){
        return  this.queryGateway
                .query("getAllUsers",null, ResponseTypes.multipleInstancesOf(GitHubUser.class));
    }

    public CompletableFuture<GitHubUser> getOneUserById(Long id){
        return this.queryGateway
                .query("getOneUserById",id,GitHubUser.class);
    }

    public Long findUserOccurrences(String login) throws ExecutionException, InterruptedException {
        log.info("Searching occurrences of user {} ",login);
        return getAll()
                .get()
                .stream()
                .filter(user->user.getLogin().equalsIgnoreCase(login))
                .count();
    }




}
