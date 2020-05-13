package com.chiraranw.gitviewscommandservice.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewRepositoriesCommand {
    @TargetAggregateIdentifier
    String id;
    String login;
    String firstRepo;

}
