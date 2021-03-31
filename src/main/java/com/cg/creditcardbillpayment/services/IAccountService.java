package com.cg.creditcardbillpayment.services;

import java.util.List;

import com.cg.creditcardbillpayment.entities.Account;

public interface IAccountService {
	public Account addAccount(Account account);

	public Account removeAccount(long id);

	public Account updateAccount(long id, Account account);

	public Account getAccount(long id);

	public List<Account> getAllAccounts();
}
