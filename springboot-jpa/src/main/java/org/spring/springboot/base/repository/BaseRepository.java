package org.spring.springboot.base.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
/**
 * @author zjx
 * TODO BaseRepository
 * 2017年8月15日
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, Serializable>{
}
