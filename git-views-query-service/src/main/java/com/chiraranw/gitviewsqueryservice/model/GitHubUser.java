package com.chiraranw.gitviewsqueryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitHubUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public  String firstRepo;
    public  String login;
}
