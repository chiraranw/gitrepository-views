package com.chiraranw.gitviewscommandservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitRepository {

    public String login;
    @JsonProperty("name")
    public String firstRepo;

    @JsonProperty("owner")
    private void unpackLoginNameFromOwner(Map<String, String> owner) {
        this.login = owner.get("login");
    }
}
