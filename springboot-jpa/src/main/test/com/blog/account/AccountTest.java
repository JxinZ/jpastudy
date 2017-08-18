package com.blog.account;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.spring.springboot.dto.AccountDto;
import org.spring.springboot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.base.BaseTest;

public class AccountTest extends BaseTest {

	@Autowired
	private AccountService accountService;
	
	/*@Test
	public void TestSave(){
		Account entity = new Account();
		entity.setName("51fasf");
		entity.setPassWord("asfasfasfa");
		accountService.saveOrUpdate(entity);
		Assert.assertTrue("正确",true);
	}*/
	
	@Test
	public void TestUpdate(){
		AccountDto entity = accountService.findOne("40287f815de4e1ef015de4e1f5210000");
		entity.setName("admin112");
		entity.setPassWord("66666");
		entity=accountService.update(entity);
		List<AccountDto> entitys = accountService.findAll();
		for(AccountDto dto : entitys){
			System.out.println("=========================");
			System.out.println(dto.toString());
		}
		System.out.println("===========================");
		System.out.println(entity.getId());
		System.out.println(entity.toString());
		Assert.assertTrue("正确",true);
	}
}
