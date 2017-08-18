package org.spring.springboot.dto;

import org.spring.springboot.domain.Account;

/**
 * @author PC-Jxin
 * 用户账户表
 */
public class AccountDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7939543831034123278L;

	/**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 描述
     */
    private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassWord() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", password=" + password + ", description=" + description + "]";
	}
	
	@SuppressWarnings("unchecked")
	public Account toEntity(){
		return super.toEntity(this,new Account());
	}
}
