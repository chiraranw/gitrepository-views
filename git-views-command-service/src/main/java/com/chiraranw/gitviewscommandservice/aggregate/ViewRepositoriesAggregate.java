package com.chiraranw.gitviewscommandservice.aggregate;

import com.chiraranw.gitviewscommandservice.commands.ViewRepositoriesCommand;
import com.chiraranw.gitviewscommandservice.events.RepositoriesViewedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Data
@NoArgsConstructor
@Aggregate
public class ViewRepositoriesAggregate {

    @AggregateIdentifier
    public String id;
    public String login;
    public String firstRepo;

    @CommandHandler
    public ViewRepositoriesAggregate(ViewRepositoriesCommand viewRepositoriesCommand){
        AggregateLifecycle.apply(
                new RepositoriesViewedEvent(
                        viewRepositoriesCommand.getId(),
                        viewRepositoriesCommand.getLogin(),
                        viewRepositoriesCommand.getFirstRepo())
        );
    }

    @EventSourcingHandler
    private void handle(RepositoriesViewedEvent repositoriesViewedEvent){
        this.id=repositoriesViewedEvent.getId();
        this.login=repositoriesViewedEvent.getLogin();
        this.firstRepo=repositoriesViewedEvent.getFirstRepo();
    }
}
