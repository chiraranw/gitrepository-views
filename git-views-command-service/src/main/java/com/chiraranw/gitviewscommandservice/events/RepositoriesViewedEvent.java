package com.chiraranw.gitviewscommandservice.events;

import lombok.Data;

@Data
public class RepositoriesViewedEvent {
    private final String id;
    private final String login;
    private final String firstRepo;
}
