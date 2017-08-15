package org.spring.springboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author PC-Jxin
 * 资源
 */
@Entity
@Table(name="resouce")
public class Resouce extends TreeBaseEntity{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4199971316285666107L;

	/**
     * 资源名称
     */
	@Column(name="res_name",columnDefinition="varchar(32) COMMENT '用户名'")
    private String resName;
	
	/**
     * 资源地址
     */
	@Column(name="res_address",columnDefinition="varchar(32) COMMENT '用户名'")
    private String resAddress;

    /**
     * 资源图标
     */
	@Column(name="res_img",columnDefinition="varchar(64) COMMENT '密码'")
    private String resImg;

    /**
     * 描述
     */
	@Column(name="description",columnDefinition="varchar(256) COMMENT '描述'")
    private String description;

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public String getResAddress() {
		return resAddress;
	}

	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}

	public String getResImg() {
		return resImg;
	}

	public void setResImg(String resImg) {
		this.resImg = resImg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Resouce [resName=" + resName + ", resAddress=" + resAddress + ", resImg=" + resImg + ", description="
				+ description + "]";
	}

}
