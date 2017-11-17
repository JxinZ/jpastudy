package org.spring.springboot.base.service;

import java.io.Serializable;
import java.util.List;

import org.spring.springboot.base.repository.BaseRepository;

public interface BaseService<T,D extends Serializable> {
	
	BaseRepository<T, Long> getRepository();
	
	List<D> findAll();

	D findOne(String id);

	void delete(String id);

	D update(D entity);

	D save(D entity);

}
