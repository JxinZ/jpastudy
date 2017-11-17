package org.spring.springboot.service;

import org.spring.springboot.base.service.BaseService;
import org.spring.springboot.domain.Account;
import org.spring.springboot.dto.AccountDto;

public interface AccountService extends BaseService<Account,AccountDto>{

	AccountDto findByName(String name);
}
