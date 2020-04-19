package com.cyq.spring.boot.blog.repository;

import java.util.List;

import com.cyq.spring.boot.blog.domain.Catalog;
import com.cyq.spring.boot.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Catalog 仓库.
 */
public interface CatalogRepository extends JpaRepository<Catalog, Long>{
	
	/**
	 * 根据用户查询
	 * @param user
	 * @return
	 */
	List<Catalog> findByUser(User user);
	
	/**
	 * 根据用户查询
	 */
	List<Catalog> findByUserAndName(User user,String name);
}
