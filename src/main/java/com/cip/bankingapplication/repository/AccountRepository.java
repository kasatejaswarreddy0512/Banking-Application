package com.cip.bankingapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cip.bankingapplication.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

}
