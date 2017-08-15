package org.spring.springboot.service.impl;

import org.spring.springboot.domain.Account;
import org.spring.springboot.repository.AccountRepository;
import org.spring.springboot.repository.BaseRepository;
import org.spring.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public BaseRepository<Account, Long> getRepository() {
		return accountRepository;
	}
}
