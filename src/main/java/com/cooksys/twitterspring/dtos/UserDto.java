package com.cooksys.twitterspring.dtos;

import com.cooksys.twitterspring.entities.Credentials;
import com.cooksys.twitterspring.entities.Profile;

public class UserDto {

	private Credentials credentials;

	private Profile profile;

	public UserDto() {

	}

	public UserDto(Credentials credentials, Profile profile) {
		this.credentials = credentials;
		this.profile = profile;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
