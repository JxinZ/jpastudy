package org.spring.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author PC-Jxin
 * 用户账户表
 */
@Entity
@Table(name="account")
public class Account extends BaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4199971316285666107L;

	/**
     * 用户名
     */
	@Column(name="name",columnDefinition="varchar(32) COMMENT '用户名'")
    private String name;

    /**
     * 密码
     */
	@Column(name="password",columnDefinition="varchar(64) COMMENT '密码'")
    private String password;

    /**
     * 描述
     */
	@Column(name="description",columnDefinition="varchar(256) COMMENT '描述'")
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
}
