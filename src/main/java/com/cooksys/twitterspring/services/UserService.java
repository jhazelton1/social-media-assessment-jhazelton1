package com.cooksys.twitterspring.services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cooksys.twitterspring.dtos.CredentialDto;
import com.cooksys.twitterspring.dtos.UserDto;
import com.cooksys.twitterspring.dtos.UserRespondDto;
import com.cooksys.twitterspring.entities.User;
import com.cooksys.twitterspring.mappers.UserMapper;
import com.cooksys.twitterspring.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository uRepo;
	private UserMapper uMapper;

	public UserService(UserRepository uRepo, UserMapper uMapper) {
		this.uRepo = uRepo;
		this.uMapper = uMapper;
	}

	public Collection<UserDto> getUsers() {
		Collection<UserDto> users = this.uMapper.toDtos(this.uRepo.findAll());
		if (users == null) {
			return new ArrayList<UserDto>();
		}
		return users;
	}

	@Transactional
	public UserRespondDto addUser(UserDto u) {
		User entity = uMapper.fromDto(u);
		uRepo.save(entity);
		return uMapper.toRespondDto(entity);
	}

	public UserRespondDto getUser(String username) {
		User entity = uRepo.findByCredentialsUsername(username);
		return uMapper.toRespondDto(entity);
	}

	@Transactional
	public UserRespondDto updateUser(String username, UserDto user) {
		User entity = uRepo.findByCredentialsUsername(username);
		if (user.getCredentials().getPassword().equals(entity.getCredentials().getPassword())) {
			entity.getProfile().setEmail(user.getProfile().getEmail());
			entity.getProfile().setFirstName(user.getProfile().getFirstName());
			entity.getProfile().setLastName(user.getProfile().getLastName());
			entity.getProfile().setPhone(user.getProfile().getPhone());
			uRepo.save(entity);
		}

		return uMapper.toRespondDto(entity);
		
	}
	
	@Transactional
	public UserRespondDto deleteUser(String username, CredentialDto credentialDto) {
		User entity = uRepo.findByCredentialsUsername(username);
		if (entity.getCredentials().getPassword().equals(credentialDto.getCredentials().getPassword())) {
			entity.setActive(false);
			uRepo.save(entity);
		}
		return uMapper.toRespondDto(entity);
	}

	@Transactional
	public void followUser(String username, CredentialDto credentialDto) {
		User entity = uRepo.findByCredentialsUsername(credentialDto.getCredentials().getUsername());
		User toFollow = uRepo.findByCredentialsUsername(username);
		if (entity.getCredentials().getPassword().equals(credentialDto.getCredentials().getPassword())) {
			entity.getFollowing().add(toFollow);
		}
		
		
	}
	
	@Transactional
	public void unFollowUser(String username, CredentialDto credentialDto) {
		User entity = uRepo.findByCredentialsUsername(credentialDto.getCredentials().getUsername());
		User toUnFollow = uRepo.findByCredentialsUsername(username);
		if (entity.getCredentials().getPassword().equals(credentialDto.getCredentials().getPassword())) {
			entity.getFollowing().remove(toUnFollow);
		}
		
	}

}
