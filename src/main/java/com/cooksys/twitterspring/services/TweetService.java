package com.cooksys.twitterspring.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.cooksys.twitterspring.dtos.TweetDto;
import com.cooksys.twitterspring.dtos.UserDto;
import com.cooksys.twitterspring.mappers.TweetMapper;
import com.cooksys.twitterspring.repositories.TweetRepository;

@Service
public class TweetService {
	
	
	private TweetRepository tRepo;
	private TweetMapper tMapper;
	
	
	public TweetService(TweetRepository tRepo, TweetMapper tMapper) {
		this.tRepo = tRepo;
		this.tMapper = tMapper;
	}

	public Collection<TweetDto> getTweets() {
		Collection<TweetDto> tweets = this.tMapper.toDtos(this.tRepo.findAll());
		if (tweets == null) {
			return new ArrayList<TweetDto>();
		}
		return tweets;
	}

}
