package org.spring.springboot.service.impl;

import java.util.List;

import org.spring.springboot.domain.Identifiable;
import org.spring.springboot.repository.BaseRepository;
import org.spring.springboot.service.BaseService;
import org.spring.springboot.util.ObjectHelper;

public abstract class BaseServiceImpl<T extends Identifiable> implements BaseService<T>{

	@Override
	public abstract BaseRepository<T, Long> getRepository();

	@Override
	public List<T> findAll() {
		return this.getRepository().findAll();
	}

	@Override
	public T getOne(String id) {
		return this.getRepository().getOne(id);
	}

	@Override
	public T saveOrUpdate(T entity) {
		if(ObjectHelper.isNotEmpty(entity.getId())){
			return this.getRepository().update(entity);
		}else{
			return this.getRepository().save(entity);
		}
	}

	@Override
	public void delete(String id) {
		this.getRepository().delete(id);
	}


}
