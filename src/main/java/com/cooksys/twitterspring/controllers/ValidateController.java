package com.cooksys.twitterspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.twitterspring.services.ValidateService;

@RestController
@RequestMapping(value = "/validate")
public class ValidateController {

	private ValidateService vService;

	public ValidateController(ValidateService vService) {
		this.vService = vService;
	}

	@GetMapping("/tag/exists/{label}")
	public boolean isTag(@PathVariable(name = "label") String label) {
		return this.vService.isTag(label);
	}
	
	@GetMapping("/tag/exists/@{username}")
	public boolean isUsername(@PathVariable(name = "username") String username) {
		return this.vService.isUsername(username);
	}
//	
	@GetMapping("/tag/available/@{username}")
	public boolean isUsernameAvailable(@PathVariable(name = "username") String username) {
		return this.vService.isUsernameAvailable(username);
	}
//	
	

}
