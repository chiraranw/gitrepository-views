package com.chiraranw.gitviewscommandservice.service;

import com.chiraranw.gitviewscommandservice.model.AccountView;
import com.chiraranw.gitviewscommandservice.model.GitRepository;
import com.chiraranw.gitviewscommandservice.model.ViewResult;
import com.chiraranw.gitviewscommandservice.repository.AccountViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountViewService {

    private final AccountViewRepository accountViewRepository;
    private final GitHubAPIService gitHubAPIService;

    @Autowired
    public AccountViewService(AccountViewRepository accountViewRepository, GitHubAPIService gitHubAPIService) {
        this.accountViewRepository = accountViewRepository;
        this.gitHubAPIService = gitHubAPIService;
    }

    public AccountView save(AccountView accountView){
        return this.accountViewRepository.save(accountView);
    }

    public ViewResult getRepo(String login){
        ViewResult viewResult= new ViewResult();
        Optional<GitRepository> gitRepository=this.gitHubAPIService.getRepoDetails(login);
        gitRepository.ifPresent(repo->{
            viewResult.setLogin(repo.getLogin());
            viewResult.setFirstRepo(repo.getFirstRepo());
        });
        return viewResult;
    }
}
