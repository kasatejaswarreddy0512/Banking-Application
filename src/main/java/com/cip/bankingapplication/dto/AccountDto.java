package com.cip.bankingapplication.dto;

public class AccountDto {
	
	private long Id;
	private String accountHolderName;
	private double balance;
	
	
	public AccountDto(Long id, String accountHolderName, double balance) {
		super();
		Id = id;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	

	public AccountDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
