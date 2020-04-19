package com.cyq.spring.boot.blog.repository;

import java.util.Collection;
import java.util.List;

import com.cyq.spring.boot.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户仓库.
 */
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * 根据用户名分页查询用户列表
	 */
	Page<User> findByNameLike(String name, Pageable pageable);
	/**
	 * 根据名称查询
	 */
	User findByUsername(String username);
	/**
	 * 根据名称列表查询
	 */
	List<User> findByUsernameIn(Collection<String> usernames);

	/**
	 * 根据email查询用户
	 */
	User findByEmail(String email);
}
