package com.chiraranw.gitviewsqueryservice.repository;

import com.chiraranw.gitviewsqueryservice.model.GitHubUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GitHubUserRepository extends JpaRepository<GitHubUser,Long> {
}
