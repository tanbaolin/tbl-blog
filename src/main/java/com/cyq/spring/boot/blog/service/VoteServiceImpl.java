package com.cyq.spring.boot.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyq.spring.boot.blog.domain.Vote;
import com.cyq.spring.boot.blog.repository.VoteRepository;

/**
 * Vote 服务.
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	/* (non-Javadoc)
	 * @see VoteService#removeVote(java.lang.Long)
	 */
	@Override
	@Transactional
	public void removeVote(Long id) {
		voteRepository.delete(id);
	}
	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}

}
