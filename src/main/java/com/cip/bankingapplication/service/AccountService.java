package com.cip.bankingapplication.service;

import java.util.List;

import com.cip.bankingapplication.dto.AccountDto;
import com.cip.bankingapplication.entity.Account;

public interface AccountService {
	
	AccountDto createAccount(AccountDto account);
	
	AccountDto getAccountById(long id);
	
	AccountDto deposit(long id, double amount);
	
	AccountDto withdraw(long id, double amount);
	
	List<AccountDto> getAllAccounts();
	
	void deleteAccount(long id);
}
