package org.spring.springboot.base.domain;

import java.io.Serializable;
import java.util.Date;

public abstract interface Identifiable extends Serializable {

	public abstract String getId();
 
	public abstract void setId(String id);

	public abstract Boolean getIsDeleted();

	public abstract void setIsDeleted(Boolean isDeleted);

	public abstract Date getCreateTime();

	public abstract void setCreateTime(Date createTime);

	public abstract Date getUpdateTime();

	public abstract void setUpdateTime(Date updateTime);

	public abstract Date getDeleteTime();

	public abstract void setDeleteTime(Date deleteTime);

	public abstract String getCreateBy();

	public abstract void setCreateBy(String createBy);

	public abstract String getUpdateBy();

	public abstract void setUpdateBy(String updateBy);

	public abstract <D> D toDto();
}
