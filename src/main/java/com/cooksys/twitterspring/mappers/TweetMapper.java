package com.cooksys.twitterspring.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;

import com.cooksys.twitterspring.dtos.TweetDto;
import com.cooksys.twitterspring.entities.Tweet;

@Mapper(componentModel = "spring")
public interface TweetMapper {

	
	Collection<TweetDto> toDtos(Collection<Tweet> tweets);
	TweetDto toDto(Tweet tweet);
	
	

}
