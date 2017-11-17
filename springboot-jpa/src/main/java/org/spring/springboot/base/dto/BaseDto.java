package org.spring.springboot.base.dto;

import org.springframework.beans.BeanUtils;

public abstract class BaseDto implements IdentifiableDto {

	private static final long serialVersionUID = 3961004285380928190L;
	
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public <D, T> T toEntity(D dto,T entity) {
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

}
