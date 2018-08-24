package com.cooksys.twitterspring.entities;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	@Embedded
	private Credentials credentials;

	@Embedded
	private Profile profile;

	private Timestamp joined;

	private boolean isActive = true;
	
	@OneToMany
	private Set<User> following;

	public User() {

	}

	public User(Integer id, Credentials credentials, Profile profile, Timestamp joined, boolean isActive,
			Set<User> following) {
		super();
		this.id = id;
		this.credentials = credentials;
		this.profile = profile;
		this.joined = joined;
		this.isActive = isActive;
		this.following = following;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Timestamp getJoined() {
		return joined;
	}

	public void setJoined(Timestamp joined) {
		this.joined = joined;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

}
