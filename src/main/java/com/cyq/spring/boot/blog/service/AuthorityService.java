package com.cyq.spring.boot.blog.service;

import com.cyq.spring.boot.blog.domain.Authority;

/**
 * Authority 服务接口.
 */
public interface AuthorityService {
	 
	
	/**
	 * 根据id获取 Authority
	 */
	Authority getAuthorityById(Long id);
}
