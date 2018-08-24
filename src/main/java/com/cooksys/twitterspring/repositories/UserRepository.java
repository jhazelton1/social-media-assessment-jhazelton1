package com.cooksys.twitterspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.twitterspring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByCredentialsUsername(String username);
	

}
