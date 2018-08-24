package com.cooksys.twitterspring.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterspring.dtos.TweetDto;
import com.cooksys.twitterspring.mappers.TweetMapper;
import com.cooksys.twitterspring.services.TweetService;

@RestController
@RequestMapping(value = "/tweets")
public class TweetController {
	
	private TweetService tService;
	private TweetMapper tMapper;
	
	public TweetController (TweetService tService, TweetMapper tMapper) {
		this.tService = tService;
		this.tMapper = tMapper;
	}
	
	@GetMapping
	public Collection<TweetDto> getTweets() {
		return this.tService.getTweets();
	}
	

}
