package com.chiraranw.gitviewscommandservice.repository;

import com.chiraranw.gitviewscommandservice.model.AccountView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountViewRepository extends JpaRepository<AccountView,Long> {
}
