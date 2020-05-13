package com.chiraranw.loginsservice.projection;

import com.chiraranw.loginsservice.event.RepositoriesViewedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;


@Component
public class LoginsProjection {

    @EventHandler
    private void on(RepositoriesViewedEvent repositoriesViewedEvent){
        System.out.println("Login has seen the event");
    }

}
