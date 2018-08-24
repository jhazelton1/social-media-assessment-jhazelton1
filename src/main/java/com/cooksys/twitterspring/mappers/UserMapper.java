package com.cooksys.twitterspring.mappers;

import java.util.Collection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.twitterspring.dtos.UserDto;
import com.cooksys.twitterspring.dtos.UserRespondDto;
import com.cooksys.twitterspring.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	@Mapping(target = "username", source = "credentials.username")
	UserRespondDto toRespondDto(User u);
	
	UserDto toDto(User u);
	
	User fromDto(UserDto dto);
	
	Collection<UserDto> toDtos(Collection<User> users);
	Collection<User> fromDtos(Collection<UserDto> dtos);

}
