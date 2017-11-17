package org.spring.springboot.repository;

import org.spring.springboot.base.repository.BaseRepository;
import org.spring.springboot.domain.Account;

/**AccountRepository.java
 * @author zjx
 * TODO
 * 2017年8月15日
 */
public interface AccountRepository extends BaseRepository<Account, Long>{
	
	Account findByName(String name);
	
}
