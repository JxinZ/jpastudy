package org.spring.springboot.dto;

import org.spring.springboot.domain.Resouce;

/**
 * @author PC-Jxin
 * 资源
 */
public class ResouceDto extends TreeBaseDto{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4199971316285666107L;

	/**
     * 资源名称
     */
    private String resName;
	
	/**
     * 资源地址
     */
    private String resAddress;

    /**
     * 资源图标
     */
    private String resImg;

    /**
     * 描述
     */
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

	@SuppressWarnings("unchecked")
	@Override
	public Resouce toEntity() {
		return super.toEntity(this,new Resouce());
	}

}
