package com.chiraranw.gitviewsqueryservice.query;

import com.chiraranw.gitviewsqueryservice.model.GitHubUser;
import com.chiraranw.gitviewsqueryservice.repository.GitHubUserRepository;
import lombok.extern.slf4j.XSlf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@XSlf4j
public class GitHubUserProjection {

    private final GitHubUserRepository gitHubUserRepository;

    @Autowired
    public GitHubUserProjection(GitHubUserRepository gitHubUserRepository) {
        this.gitHubUserRepository = gitHubUserRepository;
    }

    @QueryHandler(queryName = "getAllUsers")
    public List<GitHubUser> getAll() {
        log.trace("Retrieving results of the query {} ", "getAllUsers");
        return this.gitHubUserRepository.findAll();
    }

    @QueryHandler(queryName = "getOneUserById")
    public GitHubUser findOneUser(Long userId) {
        log.trace("Processing query for user with id {}", userId);
        Optional<GitHubUser> optionalGitHubUser = this.gitHubUserRepository.findById(userId);
        GitHubUser temp = new GitHubUser();
        optionalGitHubUser.ifPresent(u -> {
            temp.setId(u.getId());
            temp.setLogin(u.getLogin());
            temp.setFirstRepo(u.getFirstRepo());
        });
        return temp;
    }


}
