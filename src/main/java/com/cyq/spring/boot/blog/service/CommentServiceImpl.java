package com.cyq.spring.boot.blog.service;

import javax.transaction.Transactional;

import com.cyq.spring.boot.blog.domain.Comment;
import com.cyq.spring.boot.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comment 服务.
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;
	/* (non-Javadoc)
	 * @see CommentService#removeComment(java.lang.Long)
	 */
	@Override
	@Transactional
	public void removeComment(Long id) {
		commentRepository.delete(id);
	}
	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

}
