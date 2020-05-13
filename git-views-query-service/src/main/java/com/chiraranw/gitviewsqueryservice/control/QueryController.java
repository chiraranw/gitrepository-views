package com.chiraranw.gitviewsqueryservice.control;

import com.chiraranw.gitviewsqueryservice.model.GitHubUser;
import com.chiraranw.gitviewsqueryservice.service.GitHubUserService;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/git/v1/query/")
public class QueryController {
    Logger log = LoggerFactory.getLogger(QueryController.class);
    private final GitHubUserService gitHubUserService;

    @Autowired
    public QueryController(GitHubUserService gitHubUserService) {
        this.gitHubUserService = gitHubUserService;
    }

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    public CompletableFuture<List<GitHubUser>> getAll() {
        log.trace("Processing request {}", "/users/all ");
        return this.gitHubUserService
                .getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public CompletableFuture<GitHubUser> getOne(@PathVariable("id") Long id) {
        log.trace("Processing request {}", "/users/{" + id + "} ");
        return this.gitHubUserService.getOneUserById(id);
    }

    @RequestMapping(value = "/users/{login}/oc", method = RequestMethod.GET)
    public Long getUserOccurrences(@PathVariable("login") String login) throws ExecutionException, InterruptedException {
        log.info("Processing request {}", "/users/{" + login + "}/oc");
        return this.gitHubUserService.findUserOccurrences(login);
    }


}
