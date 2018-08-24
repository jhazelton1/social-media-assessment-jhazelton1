package com.cooksys.twitterspring.dtos;

import com.cooksys.twitterspring.entities.User;
import com.cooksys.twitterspring.mappers.UserMapper;

public class TweetDto {
	
	private UserMapper uMapper;
	
	private Integer id;
	
	private User author;
	
	private UserRespondDto dto;
	
	public TweetDto() {
		
	}
	
	public TweetDto(Integer id, UserRespondDto dto) {
		this.id = id;
		this.dto = uMapper.toRespondDto(this.author);
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserRespondDto getDto() {
		return dto;
	}

	public void setDto(UserRespondDto dto) {
		this.dto = dto;
	}
	
	
	
}
