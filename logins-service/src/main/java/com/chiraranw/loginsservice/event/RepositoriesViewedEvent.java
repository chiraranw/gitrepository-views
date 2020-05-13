package com.chiraranw.loginsservice.event;

import lombok.Data;

@Data
public class RepositoriesViewedEvent {
    private final String id;
    private final String login;
    private final String firstRepo;
}
