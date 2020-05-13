package com.chiraranw.gitviewscommandservice.control;

import com.chiraranw.gitviewscommandservice.commands.ViewRepositoriesCommand;
import com.chiraranw.gitviewscommandservice.model.AccountView;
import com.chiraranw.gitviewscommandservice.model.GitRepository;
import com.chiraranw.gitviewscommandservice.model.ViewResult;
import com.chiraranw.gitviewscommandservice.service.AccountViewService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@SuppressWarnings("all")
@RequestMapping(value = "/git/v1/")
public class ReposViewController {

    private final AccountViewService accountView;
    private final CommandGateway commandGateway;

    @Autowired
    public ReposViewController(AccountViewService accountView, CommandGateway commandGateway) {
        this.accountView = accountView;
        this.commandGateway = commandGateway;
    }

    @RequestMapping(value = "/view/{login}",method = RequestMethod.GET)
    public CompletableFuture<String> view(@PathVariable("login") String login) {
        //if there is a positive in the result then we fire the command

        ViewResult viewResult=this.accountView.getRepo(login);
        System.out.println("Resposne from git:"+viewResult);
        if (!Objects.isNull(viewResult.getLogin())) {
            String id= UUID.randomUUID().toString();
            return this.commandGateway
                    .send(new ViewRepositoriesCommand(id,viewResult.getLogin(),viewResult.getFirstRepo()))
                    .thenApply(response -> "Repository viewed: " + login)
                    .exceptionally(Throwable::getLocalizedMessage);
        }

        return null;

    }

}
