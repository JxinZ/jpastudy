package org.spring.springboot.service;

import java.io.Serializable;
import java.util.List;

import org.spring.springboot.repository.BaseRepository;

public interface BaseService<T extends Serializable> {
	
	BaseRepository<T, Long> getRepository();
	
	List<T> findAll();

	T getOne(String id);

	T saveOrUpdate(T entity);
	
	void delete(String id);
}
