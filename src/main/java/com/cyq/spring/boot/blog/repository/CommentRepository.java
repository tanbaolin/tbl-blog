package com.cyq.spring.boot.blog.repository;

import com.cyq.spring.boot.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment 仓库.
 */
public interface CommentRepository extends JpaRepository<Comment, Long>{
 
}
