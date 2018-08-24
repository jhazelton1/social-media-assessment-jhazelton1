package com.cooksys.twitterspring.dtos;

import com.cooksys.twitterspring.entities.Credentials;

public class CredentialDto {
	
	private Credentials credentials;
	
	public CredentialDto() {
		
	}
	
	public CredentialDto(Credentials credentials) {
		this.credentials = credentials;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	
}
