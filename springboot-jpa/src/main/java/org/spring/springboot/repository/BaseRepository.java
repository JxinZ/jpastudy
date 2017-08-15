package org.spring.springboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author zjx
 * TODO BaseRepository
 * 2017年8月15日
 * @param <T>
 * @param <ID>
 */
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, Serializable>{
	T update(T entity);
}
