package com.cooksys.twitterspring.services;

import org.springframework.stereotype.Service;

import com.cooksys.twitterspring.entities.Hashtag;
import com.cooksys.twitterspring.entities.User;
import com.cooksys.twitterspring.repositories.HashtagRepository;
import com.cooksys.twitterspring.repositories.UserRepository;


@Service
public class ValidateService {
	
	private HashtagRepository hRepo;
	private UserRepository uRepo;
	
	public ValidateService(HashtagRepository hRepo, UserRepository uRepo) {
		this.hRepo = hRepo;
		this.uRepo = uRepo;
	}
	
	public boolean isTag(String label) {
		Hashtag exists = hRepo.findByLabel(label);
		if (exists == null) {
			return false;
		}
		return true;
	}
	
	public boolean isUsername(String username) {
		User exists = uRepo.findByCredentialsUsername(username);
		if (exists == null) {
			return false;
		}
		return true;
		
	}

	public boolean isUsernameAvailable(String username) {
		User exists = uRepo.findByCredentialsUsername(username);
		if (exists == null) {
			return true;
		}
		return false;
	}
	
	
}
