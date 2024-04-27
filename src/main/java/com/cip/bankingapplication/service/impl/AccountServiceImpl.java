package com.cip.bankingapplication.service.impl;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cip.bankingapplication.dto.AccountDto;
import com.cip.bankingapplication.entity.Account;
import com.cip.bankingapplication.mapper.AccountMapper;
import com.cip.bankingapplication.repository.AccountRepository;
import com.cip.bankingapplication.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		
		Account account=AccountMapper.mapToAccount(accountDto);
		Account savedAccount=accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto getAccountById(long id) {
		
	Account account=	accountRepository.findById(id).orElseThrow(( )-> new RuntimeException("Account does not exist"));
		
		
		return AccountMapper.mapToAccountDto(account);
	}



	@Override
	public AccountDto deposit(long id, double amount) {
		
		Account account=	accountRepository.findById(id).orElseThrow(( )-> new RuntimeException("Account does not exist"));
		double totalBalance=account.getBalance()+amount;
		account.setBalance(totalBalance);
		Account savedAccount= accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public AccountDto withdraw(long id, double amount) {
		
		Account account=	accountRepository.findById(id).orElseThrow(( )-> new RuntimeException("Account does not exist"));
		
		if(account.getBalance()<amount)
		{
			throw new RuntimeException("Insufficint Balance");
		}
		double totalBalance=account.getBalance()-amount;
		account.setBalance(totalBalance);
		Account savedAccount= accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(savedAccount);
	}



	@Override
	public List<AccountDto> getAllAccounts() {
		
	return	accountRepository.findAll().stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

	}



	@Override
	public void deleteAccount(long id) {
		Account account=	accountRepository.findById(id).orElseThrow(( )-> new RuntimeException("Account does not exist"));
		accountRepository.delete(account);
	}
	
	








	
}
