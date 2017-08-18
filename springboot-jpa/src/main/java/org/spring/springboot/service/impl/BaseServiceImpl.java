package org.spring.springboot.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.domain.Identifiable;
import org.spring.springboot.dto.IdentifiableDto;
import org.spring.springboot.repository.BaseRepository;
import org.spring.springboot.service.BaseService;
import org.spring.springboot.util.ObjectHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseServiceImpl<T extends Identifiable,D extends IdentifiableDto> implements BaseService<T,D>{

	Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
	
	@Override
	public abstract BaseRepository<T, Long> getRepository();

	@Override
	public List<D> findAll() {
		List<T> entitys = this.getRepository().findAll();
		List<D> dtos = new ArrayList<>(); 
		for(T entity:entitys){
			D dto = entity.toDto();
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public D findOne(String id) {
		return this.getRepository().findOne(id).toDto();
	}

	@Transactional
	public T saveOrUpdate(T entity) {
		if(ObjectHelper.isNotEmpty(entity.getId())){
			entity.setUpdateTime(new Date());
		}else{
			entity.setCreateTime(new Date());
		}
		return this.getRepository().save(entity);
	}
	
	@Override
	@Transactional
	public D save(D dto) {
		T entity = dto.toEntity();
		entity=this.saveOrUpdate(entity);
		dto.setId(entity.getId());
		return dto;
	}
	
	@Override
	@Transactional
	public D update(D dto) {
		T entity = this.getRepository().findOne(dto.getId());
		BeanUtils.copyProperties(dto, entity,new String[]{"id"});
		entity=this.saveOrUpdate(entity);
		return dto;
	}
	
	@Override
	public void delete(String id) {
		this.getRepository().delete(id);
	}


}
