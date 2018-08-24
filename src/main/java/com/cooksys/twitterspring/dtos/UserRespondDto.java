package com.cooksys.twitterspring.dtos;

import java.sql.Timestamp;

import com.cooksys.twitterspring.entities.Credentials;
import com.cooksys.twitterspring.entities.Profile;

public class UserRespondDto {
	
	
	
	private String username;
	
	private Profile profile;
	
	private Timestamp joined;
	
	public UserRespondDto() {
		
	}
	
	public UserRespondDto(String username, Profile profile, Timestamp joined) {
		this.username = username;
		this.profile = profile;
		this.joined = joined;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}
	
	

}
