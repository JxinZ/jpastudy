package org.spring.springboot.base.dto;

import java.io.Serializable;

public abstract interface IdentifiableDto extends Serializable {

	public abstract String getId();
 
	public abstract void setId(String id);

	public abstract <T> T toEntity();
}
