package com.chiraranw.gitviewscommandservice.projection;

import com.chiraranw.gitviewscommandservice.events.RepositoriesViewedEvent;
import com.chiraranw.gitviewscommandservice.model.AccountView;
import com.chiraranw.gitviewscommandservice.service.AccountViewService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ViewReposProjection {

    private  final AccountViewService accountViewService;

    @Autowired
    public ViewReposProjection(AccountViewService accountViewService) {
        this.accountViewService = accountViewService;
    }

    @EventHandler
    private void on(RepositoriesViewedEvent repositoriesViewedEvent){
        AccountView accountView= new AccountView();
        accountView.setFirstRepo(repositoriesViewedEvent.getFirstRepo());
        accountView.setLogin(repositoriesViewedEvent.getLogin());
        this.accountViewService.save(accountView);
    }
}
