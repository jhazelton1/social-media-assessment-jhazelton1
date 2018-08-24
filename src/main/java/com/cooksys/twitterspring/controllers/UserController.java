package com.cooksys.twitterspring.controllers;

import java.util.Collection;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterspring.dtos.CredentialDto;
import com.cooksys.twitterspring.dtos.UserDto;
import com.cooksys.twitterspring.dtos.UserRespondDto;
import com.cooksys.twitterspring.mappers.UserMapper;
import com.cooksys.twitterspring.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private UserService uService;
	private UserMapper uMapper;
	
	
	public UserController(UserService uService, UserMapper uMapper) {
		this.uService = uService;
		this.uMapper = uMapper;
	}
	
	@GetMapping
	public Collection<UserDto> getUsers() {
		return this.uService.getUsers();
	}
	
	@PostMapping
	public UserRespondDto addUser(@RequestBody UserDto user) {
		UserRespondDto response = uService.addUser(user);
		return response;
	}
	
	@GetMapping(value = "/@{username}")
	public UserRespondDto getUser(@PathVariable(name = "username") String username) {
		UserRespondDto user = uService.getUser(username);
		return user;
	}
	
	@PatchMapping(value = "/@{username}") 
	public UserRespondDto updateUser(@PathVariable(name = "username") String username, @RequestBody UserDto user) {
		UserRespondDto response = uService.updateUser(username, user);
		return response;
	}
	
	@DeleteMapping(value = "/@{username}") 
	public UserRespondDto deleteUser(@PathVariable(name = "username") String username, @RequestBody CredentialDto credentialDto) {
		UserRespondDto response = uService.deleteUser(username, credentialDto);
		return response;
	}
	
	@PostMapping(value = "/@{username}/follow")
	public void followUser(@PathVariable(name = "username") String username, @RequestBody CredentialDto credentialDto) {
		uService.followUser(username, credentialDto);
	}
	
	@PostMapping(value = "/@{username}/unfollow")
	public void unFollowUser(@PathVariable(name = "username") String username, @RequestBody CredentialDto credentialDto) {
		uService.unFollowUser(username, credentialDto);
	}
		
	
	

}
