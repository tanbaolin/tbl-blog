package com.cyq.spring.boot.blog.repository;

import com.cyq.spring.boot.blog.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Vote 仓库.
 */
public interface VoteRepository extends JpaRepository<Vote, Long>{
 
}
