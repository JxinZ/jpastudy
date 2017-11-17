package org.spring.springboot.service.impl;

import org.spring.springboot.base.repository.BaseRepository;
import org.spring.springboot.base.service.impl.BaseServiceImpl;
import org.spring.springboot.domain.Account;
import org.spring.springboot.dto.AccountDto;
import org.spring.springboot.repository.AccountRepository;
import org.spring.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account,AccountDto> implements AccountService{

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public BaseRepository<Account, Long> getRepository() {
		return accountRepository;
	}

	@Override
	public AccountDto findByName(String name) {
		return accountRepository.findByName(name).toDto();
	}
}
