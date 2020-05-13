package com.chiraranw.loginsservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings({"JpaDataSourceORMInspection"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "githubusers")
public class GitHubUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String login;
    public String role;
    public String password;
}
