package com.chiraranw.gitviewscommandservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name="accounts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountView {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String login;
    public String firstRepo;
}
